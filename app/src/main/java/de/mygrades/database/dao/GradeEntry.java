package de.mygrades.database.dao;

import de.mygrades.database.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import android.util.Base64;
import java.io.UnsupportedEncodingException;
// KEEP INCLUDES END
/**
 * Entity mapped to table "GRADE_ENTRY".
 */
public class GradeEntry {

    /** Not-null value. */
    private String name;
    private Double grade;
    private String examId;
    private String semester;
    private String state;
    private Double creditPoints;
    private String annotation;
    private String attempt;
    private String examDate;
    private Integer semesterNumber;
    private String tester;
    private String hash;
    private Boolean overviewPossible;
    private Integer seen;
    private Boolean overviewFailedOnFirstTry;
    private Integer weight;
    private String modifiedName;
    private Double modifiedGrade;
    private String modifiedExamId;
    private String modifiedState;
    private Double modifiedCreditPoints;
    private String modifiedAnnotation;
    private String modifiedAttempt;
    private String modifiedExamDate;
    private String modifiedTester;
    private Long overviewId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient GradeEntryDao myDao;

    private Overview overview;
    private Long overview__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public GradeEntry() {
    }

    public GradeEntry(String hash) {
        this.hash = hash;
    }

    public GradeEntry(String name, Double grade, String examId, String semester, String state, Double creditPoints, String annotation, String attempt, String examDate, Integer semesterNumber, String tester, String hash, Boolean overviewPossible, Integer seen, Boolean overviewFailedOnFirstTry, Integer weight, String modifiedName, Double modifiedGrade, String modifiedExamId, String modifiedState, Double modifiedCreditPoints, String modifiedAnnotation, String modifiedAttempt, String modifiedExamDate, String modifiedTester, Long overviewId) {
        this.name = name;
        this.grade = grade;
        this.examId = examId;
        this.semester = semester;
        this.state = state;
        this.creditPoints = creditPoints;
        this.annotation = annotation;
        this.attempt = attempt;
        this.examDate = examDate;
        this.semesterNumber = semesterNumber;
        this.tester = tester;
        this.hash = hash;
        this.overviewPossible = overviewPossible;
        this.seen = seen;
        this.overviewFailedOnFirstTry = overviewFailedOnFirstTry;
        this.weight = weight;
        this.modifiedName = modifiedName;
        this.modifiedGrade = modifiedGrade;
        this.modifiedExamId = modifiedExamId;
        this.modifiedState = modifiedState;
        this.modifiedCreditPoints = modifiedCreditPoints;
        this.modifiedAnnotation = modifiedAnnotation;
        this.modifiedAttempt = modifiedAttempt;
        this.modifiedExamDate = modifiedExamDate;
        this.modifiedTester = modifiedTester;
        this.overviewId = overviewId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGradeEntryDao() : null;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(Double creditPoints) {
        this.creditPoints = creditPoints;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAttempt() {
        return attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public Integer getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(Integer semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Boolean getOverviewPossible() {
        return overviewPossible;
    }

    public void setOverviewPossible(Boolean overviewPossible) {
        this.overviewPossible = overviewPossible;
    }

    public Integer getSeen() {
        return seen;
    }

    public void setSeen(Integer seen) {
        this.seen = seen;
    }

    public Boolean getOverviewFailedOnFirstTry() {
        return overviewFailedOnFirstTry;
    }

    public void setOverviewFailedOnFirstTry(Boolean overviewFailedOnFirstTry) {
        this.overviewFailedOnFirstTry = overviewFailedOnFirstTry;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public void setModifiedName(String modifiedName) {
        this.modifiedName = modifiedName;
    }

    public Double getModifiedGrade() {
        return modifiedGrade;
    }

    public void setModifiedGrade(Double modifiedGrade) {
        this.modifiedGrade = modifiedGrade;
    }

    public String getModifiedExamId() {
        return modifiedExamId;
    }

    public void setModifiedExamId(String modifiedExamId) {
        this.modifiedExamId = modifiedExamId;
    }

    public String getModifiedState() {
        return modifiedState;
    }

    public void setModifiedState(String modifiedState) {
        this.modifiedState = modifiedState;
    }

    public Double getModifiedCreditPoints() {
        return modifiedCreditPoints;
    }

    public void setModifiedCreditPoints(Double modifiedCreditPoints) {
        this.modifiedCreditPoints = modifiedCreditPoints;
    }

    public String getModifiedAnnotation() {
        return modifiedAnnotation;
    }

    public void setModifiedAnnotation(String modifiedAnnotation) {
        this.modifiedAnnotation = modifiedAnnotation;
    }

    public String getModifiedAttempt() {
        return modifiedAttempt;
    }

    public void setModifiedAttempt(String modifiedAttempt) {
        this.modifiedAttempt = modifiedAttempt;
    }

    public String getModifiedExamDate() {
        return modifiedExamDate;
    }

    public void setModifiedExamDate(String modifiedExamDate) {
        this.modifiedExamDate = modifiedExamDate;
    }

    public String getModifiedTester() {
        return modifiedTester;
    }

    public void setModifiedTester(String modifiedTester) {
        this.modifiedTester = modifiedTester;
    }

    public Long getOverviewId() {
        return overviewId;
    }

    public void setOverviewId(Long overviewId) {
        this.overviewId = overviewId;
    }

    /** To-one relationship, resolved on first access. */
    public Overview getOverview() {
        Long __key = this.overviewId;
        if (overview__resolvedKey == null || !overview__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OverviewDao targetDao = daoSession.getOverviewDao();
            Overview overviewNew = targetDao.load(__key);
            synchronized (this) {
                overview = overviewNew;
            	overview__resolvedKey = __key;
            }
        }
        return overview;
    }

    public void setOverview(Overview overview) {
        synchronized (this) {
            this.overview = overview;
            overviewId = overview == null ? null : overview.getOverviewId();
            overview__resolvedKey = overviewId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here

    /**
     * The hash is used as the primary key.
     */
    public void updateHash() {
        hash = (examId == null ? "" : examId) +
               (semester == null ? "" : semester) +
               (name == null ? "" : name) +
               (attempt == null ? "" : attempt);

        hash = toBase64(hash);
    }

    /**
     * Encode a given string to base64 string.
     *
     * @param s - string to encode
     * @return base64 string
     */
    public static String toBase64(String s) {
        try {
            byte[] data = s.getBytes("UTF-8");
            return Base64.encodeToString(data, Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            return s;
        }
    }

    @Override
    public String toString() {
        return "GradeEntry{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", examId='" + examId + '\'' +
                ", semester='" + semester + '\'' +
                ", state='" + state + '\'' +
                ", creditPoints=" + creditPoints +
                ", annotation='" + annotation + '\'' +
                ", attempt='" + attempt + '\'' +
                ", examDate='" + examDate + '\'' +
                ", semesterNumber=" + semesterNumber +
                ", tester='" + tester + '\'' +
                ", hash='" + hash + '\'' +
                ", overviewPossible=" + overviewPossible +
                ", overviewId=" + overviewId +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                ", overview=" + overview +
                ", overview__resolvedKey=" + overview__resolvedKey +
                '}';
    }

    /**
     * Updates GradeEntry with values from other GradeEntry.
     * @param other GradeEntry from which values should get updated
     */
    public void updateGradeEntryFromOther(GradeEntry other) {
        this.name = other.name;
        this.grade = other.grade;
        this.examId = other.examId;
        this.semester = other.semester;
        this.state = other.state;
        this.creditPoints = other.creditPoints;
        this.annotation = other.annotation;
        this.attempt = other.attempt;
        this.examDate = other.examDate;
        this.tester = other.tester;
        this.semesterNumber = other.semesterNumber;
        this.overviewPossible = other.overviewPossible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeEntry that = (GradeEntry) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (examId != null ? !examId.equals(that.examId) : that.examId != null) return false;
        if (semester != null ? !semester.equals(that.semester) : that.semester != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (creditPoints != null ? !creditPoints.equals(that.creditPoints) : that.creditPoints != null)
            return false;
        if (annotation != null ? !annotation.equals(that.annotation) : that.annotation != null)
            return false;
        if (attempt != null ? !attempt.equals(that.attempt) : that.attempt != null) return false;
        if (examDate != null ? !examDate.equals(that.examDate) : that.examDate != null)
            return false;
        if (semesterNumber != null ? !semesterNumber.equals(that.semesterNumber) : that.semesterNumber != null)
            return false;
        if (tester != null ? !tester.equals(that.tester) : that.tester != null) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        return !(overviewPossible != null ? !overviewPossible.equals(that.overviewPossible) : that.overviewPossible != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (examId != null ? examId.hashCode() : 0);
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (creditPoints != null ? creditPoints.hashCode() : 0);
        result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
        result = 31 * result + (attempt != null ? attempt.hashCode() : 0);
        result = 31 * result + (examDate != null ? examDate.hashCode() : 0);
        result = 31 * result + (semesterNumber != null ? semesterNumber.hashCode() : 0);
        result = 31 * result + (tester != null ? tester.hashCode() : 0);
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + (overviewPossible != null ? overviewPossible.hashCode() : 0);
        return result;
    }
    // KEEP METHODS END

}
