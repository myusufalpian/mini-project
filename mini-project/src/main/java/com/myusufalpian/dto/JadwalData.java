package com.myusufalpian.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class JadwalData {

    private String hari;

    private String waktu;
}
