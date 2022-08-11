package com.myusufalpian.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Calendar;

@Setter
@Getter
public class KehadiranData {

    private Calendar tgl;

    @NotEmpty(message = "Jenis Kehadiran Tidak Boleh Kosong")
    private String jenis;

    private String keterangan;

}