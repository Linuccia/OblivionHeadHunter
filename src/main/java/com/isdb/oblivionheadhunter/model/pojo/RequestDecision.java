package com.isdb.oblivionheadhunter.model.pojo;

import com.isdb.oblivionheadhunter.model.Request;
import lombok.Data;

@Data
public class RequestDecision {

    private Request request;
    private String decision;
    private String rang;

}
