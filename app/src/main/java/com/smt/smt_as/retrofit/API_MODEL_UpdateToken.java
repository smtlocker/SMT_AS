package com.smt.smt_as.retrofit;

public class API_MODEL_UpdateToken {

    String result;
    String description;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "API_MODEL_UpdateToken{" +
                "result='" + result + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
