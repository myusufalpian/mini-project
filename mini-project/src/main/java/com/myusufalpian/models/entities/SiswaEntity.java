package com.myusufalpian.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_siswa")
public class SiswaEntity extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "nis", length = 16)
    private String nis;

    @NotEmpty(message = "Nama Tidak Boleh Kosong")
    @Column(name = "nama", length = 100)
    private String nama;

    @Column(name = "tempat", length = 30)
    private String tempat;

    @Column(name = "tgl_lahir")
    @Temporal(TemporalType.DATE)
    private Calendar tgl;

    @NotEmpty(message = "No. Telpon Tidak Boleh Kosong")
    @Column(name = "telp", length = 14)
    private String telp;

    @NotEmpty(message = "Alamat Tidak Boleh Kosong")
    @Column(name = "alamat", length = 300)
    private String alamat;

    @ManyToMany(mappedBy = "siswa")
    @JsonIgnore
    private Set<KehadiranEntity> kehadiran;
}
