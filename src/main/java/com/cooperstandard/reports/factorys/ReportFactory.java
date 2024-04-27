package com.cooperstandard.reports.factorys;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author rsouza10
 * @param <T>
 */
public interface ReportFactory <T> extends Serializable{
    
    public List<T> generateCollection();
    public List<T> generateCollection(String param1, int param2);
    
}
