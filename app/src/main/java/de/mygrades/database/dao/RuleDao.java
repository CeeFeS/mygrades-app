package de.mygrades.database.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import de.mygrades.database.dao.Rule;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RULE".
*/
public class RuleDao extends AbstractDao<Rule, Long> {

    public static final String TABLENAME = "RULE";

    /**
     * Properties of entity Rule.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property RuleId = new Property(0, Long.class, "ruleId", true, "RULE_ID");
        public final static Property Type = new Property(1, String.class, "type", false, "TYPE");
        public final static Property LastUpdated = new Property(2, java.util.Date.class, "lastUpdated", false, "LAST_UPDATED");
        public final static Property UniversityId = new Property(3, long.class, "universityId", false, "UNIVERSITY_ID");
    };

    private DaoSession daoSession;

    private Query<Rule> university_RulesQuery;

    public RuleDao(DaoConfig config) {
        super(config);
    }
    
    public RuleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RULE\" (" + //
                "\"RULE_ID\" INTEGER PRIMARY KEY ," + // 0: ruleId
                "\"TYPE\" TEXT NOT NULL ," + // 1: type
                "\"LAST_UPDATED\" INTEGER," + // 2: lastUpdated
                "\"UNIVERSITY_ID\" INTEGER NOT NULL );"); // 3: universityId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RULE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Rule entity) {
        stmt.clearBindings();
 
        Long ruleId = entity.getRuleId();
        if (ruleId != null) {
            stmt.bindLong(1, ruleId);
        }
        stmt.bindString(2, entity.getType());
 
        java.util.Date lastUpdated = entity.getLastUpdated();
        if (lastUpdated != null) {
            stmt.bindLong(3, lastUpdated.getTime());
        }
        stmt.bindLong(4, entity.getUniversityId());
    }

    @Override
    protected void attachEntity(Rule entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Rule readEntity(Cursor cursor, int offset) {
        Rule entity = new Rule( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // ruleId
            cursor.getString(offset + 1), // type
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // lastUpdated
            cursor.getLong(offset + 3) // universityId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Rule entity, int offset) {
        entity.setRuleId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setType(cursor.getString(offset + 1));
        entity.setLastUpdated(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setUniversityId(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Rule entity, long rowId) {
        entity.setRuleId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Rule entity) {
        if(entity != null) {
            return entity.getRuleId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "rules" to-many relationship of University. */
    public List<Rule> _queryUniversity_Rules(long universityId) {
        synchronized (this) {
            if (university_RulesQuery == null) {
                QueryBuilder<Rule> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UniversityId.eq(null));
                university_RulesQuery = queryBuilder.build();
            }
        }
        Query<Rule> query = university_RulesQuery.forCurrentThread();
        query.setParameter(0, universityId);
        return query.list();
    }

}
