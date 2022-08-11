package com.myusufalpian.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class KelasData {

    @NotEmpty(message = "Nama Kelas Tidak Boleh Kosong")
    private String nama;

}
