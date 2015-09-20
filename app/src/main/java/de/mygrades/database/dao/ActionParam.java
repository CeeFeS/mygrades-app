package de.mygrades.database.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "ACTION_PARAM".
 */
public class ActionParam {

    private Long id;
    private long actionParamId;
    /** Not-null value. */
    private String key;
    private String value;
    private String type;
    private long actionId;

    public ActionParam() {
    }

    public ActionParam(Long id) {
        this.id = id;
    }

    public ActionParam(Long id, long actionParamId, String key, String value, String type, long actionId) {
        this.id = id;
        this.actionParamId = actionParamId;
        this.key = key;
        this.value = value;
        this.type = type;
        this.actionId = actionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getActionParamId() {
        return actionParamId;
    }

    public void setActionParamId(long actionParamId) {
        this.actionParamId = actionParamId;
    }

    /** Not-null value. */
    public String getKey() {
        return key;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

}
