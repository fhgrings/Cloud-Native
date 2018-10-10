package com.github.vinifkroth.cloudnative.tema7.dto;

public class TotalRepositoriesDto {

	private int total_count;

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	
	@Override
	public String toString() {
		return Integer.toString(total_count);
	}

}
