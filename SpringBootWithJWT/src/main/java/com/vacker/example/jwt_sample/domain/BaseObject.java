package com.vacker.example.jwt_sample.domain;

import java.io.Serializable;

public abstract class BaseObject implements Serializable {

	
	private static final long serialVersionUID = 4681086413361960433L;
	
	/**
     * Returns a multi-line String with key=value pairs.
     * 
     * @return a String representation of this class.
     */
    public abstract String toString();

    /**
     * Compares object equality.
     * 
     * @param o
     *   object to compare to
     * @return true/false based on equality tests
     */
    public abstract boolean equals(Object o);

    /**
     * When you override equals, you should override hashCode.
     * @return hashCode
     */
    public abstract int hashCode();

}
