package com.myusufalpian.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class PelajaranData {
    private String nama;

    @NotEmpty(message = "Jenis Mata Pelajaran Tidak Boleh Kosong")
    private String jenis;
}
