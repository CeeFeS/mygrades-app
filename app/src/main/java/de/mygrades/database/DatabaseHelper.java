package de.mygrades.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import de.mygrades.database.dao.ActionDao;
import de.mygrades.database.dao.ActionParamDao;
import de.mygrades.database.dao.DaoMaster;
import de.mygrades.database.dao.GradeEntry;
import de.mygrades.database.dao.GradeEntryDao;
import de.mygrades.database.dao.OverviewDao;
import de.mygrades.database.dao.RuleDao;
import de.mygrades.database.dao.TransformerMappingDao;
import de.mygrades.database.dao.UniversityDao;
import de.mygrades.main.processor.LoginProcessor;

/**
 * DatabaseHelper to migrate database tables at version changes.
 */
public class DatabaseHelper extends DaoMaster.OpenHelper {
    private Context context;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
        this.context = context.getApplicationContext();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion);

        // important: old/new version refers to database schema version, not the app version
        if (oldVersion < 2) {
            reset(db);
        } else if (oldVersion == 2 && newVersion == 3) {
            upgrade2to3(db);
        }
    }

    private void upgrade2to3(SQLiteDatabase db) {
        // remove empty overviews
        removeEmptyOverviews(db);

        // update GradeEntry hash
        updateGradeEntryHash(db);

        // add new columns 'OVERVIEW_FAILED_ON_FIRST_TRY' to table 'GRADE_ENTRY'
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN OVERVIEW_FAILED_ON_FIRST_TRY INTEGER;");

        // add columns for edit mode to table 'GRADE_ENTRY';
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_NAME TEXT;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_GRADE REAL;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_EXAM_ID TEXT;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_STATE TEXT;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_CREDIT_POINTS REAL;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_ANNOTATION TEXT;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_ATTEMPT TEXT;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_EXAM_DATE;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_TESTER TEXT;");
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN MODIFIED_SEMESTER TEXT;");

        // add 'weight' to table 'GRADE_ENTRY' and set default value
        db.execSQL("ALTER TABLE GRADE_ENTRY ADD COLUMN WEIGHT REAL;");
        db.execSQL("UPDATE GRADE_ENTRY SET WEIGHT = 1;");

        // remove semesterNumber
        removeSemesterNumber(db);
    }

    /**
     * Drop the column 'semester_number' by creating a copy of the whole table,
     * copy all other fields and drop the old one.
     *
     * @param db SQLiteDatabase
     */
    private void removeSemesterNumber(SQLiteDatabase db) {
        db.execSQL("BEGIN TRANSACTION;");
        db.execSQL("CREATE TABLE \"GRADE_ENTRY_BACKUP\" (" + //
                "\"NAME\" TEXT NOT NULL ," + // 0: name
                "\"GRADE\" REAL," + // 1: grade
                "\"EXAM_ID\" TEXT," + // 2: examId
                "\"SEMESTER\" TEXT," + // 3: semester
                "\"STATE\" TEXT," + // 4: state
                "\"CREDIT_POINTS\" REAL," + // 5: creditPoints
                "\"ANNOTATION\" TEXT," + // 6: annotation
                "\"ATTEMPT\" TEXT," + // 7: attempt
                "\"EXAM_DATE\" TEXT," + // 8: examDate
                "\"TESTER\" TEXT," + // 9: tester
                "\"HASH\" TEXT PRIMARY KEY NOT NULL ," + // 10: hash
                "\"OVERVIEW_POSSIBLE\" INTEGER," + // 11: overviewPossible
                "\"SEEN\" INTEGER," + // 12: seen
                "\"OVERVIEW_FAILED_ON_FIRST_TRY\" INTEGER," + // 13: overviewFailedOnFirstTry
                "\"WEIGHT\" REAL," + // 14: weight
                "\"MODIFIED_NAME\" TEXT," + // 15: modifiedName
                "\"MODIFIED_GRADE\" REAL," + // 16: modifiedGrade
                "\"MODIFIED_EXAM_ID\" TEXT," + // 17: modifiedExamId
                "\"MODIFIED_STATE\" TEXT," + // 18: modifiedState
                "\"MODIFIED_CREDIT_POINTS\" REAL," + // 19: modifiedCreditPoints
                "\"MODIFIED_ANNOTATION\" TEXT," + // 20: modifiedAnnotation
                "\"MODIFIED_ATTEMPT\" TEXT," + // 21: modifiedAttempt
                "\"MODIFIED_EXAM_DATE\" TEXT," + // 22: modifiedExamDate
                "\"MODIFIED_TESTER\" TEXT," + // 23: modifiedTester
                "\"MODIFIED_SEMESTER\" TEXT," + // 24: modifiedSemester
                "\"OVERVIEW_ID\" INTEGER);"); // 25: overviewId
        db.execSQL("INSERT INTO GRADE_ENTRY_BACKUP " +
                "SELECT " +
                "NAME, GRADE, EXAM_ID, SEMESTER, STATE, CREDIT_POINTS, ANNOTATION, ATTEMPT, " +
                "EXAM_DATE, TESTER, HASH, OVERVIEW_POSSIBLE, SEEN, OVERVIEW_FAILED_ON_FIRST_TRY, " +
                "WEIGHT, MODIFIED_NAME, MODIFIED_GRADE, MODIFIED_EXAM_ID, MODIFIED_STATE, " +
                "MODIFIED_CREDIT_POINTS, MODIFIED_ANNOTATION, MODIFIED_ATTEMPT, MODIFIED_EXAM_DATE, " +
                "MODIFIED_TESTER, MODIFIED_SEMESTER, OVERVIEW_ID " +
                "FROM GRADE_ENTRY;");
        db.execSQL("DROP TABLE GRADE_ENTRY;");
        db.execSQL("ALTER TABLE GRADE_ENTRY_BACKUP RENAME TO GRADE_ENTRY;");
        db.execSQL("COMMIT;");
    }

    /**
     * Resets database and all preferences.
     * Should be used as a fallback if no migrations are supplied.
     *
     * @param db SQLiteDatabase
     */
    private void reset(SQLiteDatabase db) {
        LoginProcessor loginProcessor = new LoginProcessor(context);
        loginProcessor.deletePreferences();

        dropAllTables(db);
        onCreate(db);
    }

    /**
     * Drops all tables.
     *
     * @param db SQLiteDatabase
     */
    private void dropAllTables(SQLiteDatabase db) {
        boolean ifExists = true;
        UniversityDao.dropTable(db, ifExists);
        RuleDao.dropTable(db, ifExists);
        ActionDao.dropTable(db, ifExists);
        ActionParamDao.dropTable(db, ifExists);
        TransformerMappingDao.dropTable(db, ifExists);
        GradeEntryDao.dropTable(db, ifExists);
        OverviewDao.dropTable(db, ifExists);
    }

    /**
     * Updates all GradeEntry hashes (primary keys).
     * 'Attempt' is appended to the existing hash to provide better distinguishable hash values.
     *
     * @param db SQLiteDatabase
     */
    private void updateGradeEntryHash(SQLiteDatabase db) {
        // select all grade entries
        String sql = "SELECT exam_id, name, semester, attempt, hash FROM grade_entry;";
        Cursor c = db.rawQuery(sql, new String[] {});

        while (c.moveToNext()) {
            String examId = c.getString(c.getColumnIndex("EXAM_ID"));
            String semester = c.getString(c.getColumnIndex("SEMESTER"));
            String name = c.getString(c.getColumnIndex("NAME"));
            String attempt = c.getString(c.getColumnIndex("ATTEMPT"));
            String oldHash = c.getString(c.getColumnIndex("HASH"));

            // create new hash
            String hash = (examId == null ? "" : examId) +
                    (semester == null ? "" : semester) +
                    (name == null ? "" : name) +
                    (attempt == null ? "" : attempt);
            hash = GradeEntry.toBase64(hash);

            // update hash in database
            ContentValues values = new ContentValues();
            values.put("HASH", hash);
            db.update("GRADE_ENTRY", values, "HASH = ?", new String[]{oldHash});

            // update grade entry hash values for overview
            values = new ContentValues();
            values.put("GRADE_ENTRY_HASH", hash);
            db.update("OVERVIEW", values, "GRADE_ENTRY_HASH = ?", new String[]{oldHash});
        }
        c.close();
    }

    /**
     * Removes empty overviews which failed due to incorrect parser configuration.
     *
     * @param db SQLiteDatabase
     */
    private void removeEmptyOverviews(SQLiteDatabase db) {
        // select all overviews
        String sql = "SELECT overview_id, average, participants, section1, section2, section3, section4, section5 FROM overview;";
        Cursor c = db.rawQuery(sql, new String[] {});

        while (c.moveToNext()) {
            if (c.isNull(c.getColumnIndex("AVERAGE")) &&
                c.isNull(c.getColumnIndex("PARTICIPANTS")) &&
                c.getInt(c.getColumnIndex("SECTION1")) == 0 &&
                c.getInt(c.getColumnIndex("SECTION2")) == 0 &&
                c.getInt(c.getColumnIndex("SECTION3")) == 0 &&
                c.getInt(c.getColumnIndex("SECTION4")) == 0 &&
                c.getInt(c.getColumnIndex("SECTION5")) == 0) {

                // delete current overview
                long overviewId = c.getInt(c.getColumnIndex("OVERVIEW_ID"));
                db.delete("OVERVIEW", "OVERVIEW_ID = ?", new String[] {""+overviewId});
            }
        }
        c.close();
    }
}
