package com.theatreManagement.project.exception;

@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {
	ApplicationException(String s){
		super(s,null);
	}
	ApplicationException(Throwable cause){
		super(null,cause);
	}
}
