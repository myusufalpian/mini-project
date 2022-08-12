package com.myusufalpian.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Calendar;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_guru")
public class GuruEntity extends BaseEntity<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "nip", length = 16)
    private String nip;

    @NotEmpty(message = "Nama Tidak Boleh Kosong")
    @Column(name = "nama", length = 100)
    private String nama;

    @Column(name = "tempat", length = 30)
    private String tempat;

    @Column(name = "tgl_lahir")
    @Temporal(TemporalType.DATE)
    private Calendar tgl;

    @NotEmpty(message = "No. Telp Tidak Boleh Kosong")
    @Column(name = "telp", length = 14)
    private String telp;

    @NotEmpty(message = "Alamat Tidak Boleh Kosong")
    @Column(name = "alamat", length = 300)
    private String alamat;

}
