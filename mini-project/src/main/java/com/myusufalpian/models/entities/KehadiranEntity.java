package com.myusufalpian.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_kehadiran")
public class KehadiranEntity extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_kehadiran")
    private Calendar tgl;

    @Column(name = "jenis_kehadiran", length = 20)
    private String jenis;

    @Column(name = "keterangan_kehadiran", length = 300)
    private String keterangan;

    @ManyToMany
    @JoinTable(
            name = "tb_kehadiran_siswa",
            joinColumns = @JoinColumn(name = "kehadiran_id"),
            inverseJoinColumns = @JoinColumn(name = "siswa_nis")
    )
    private Set<SiswaEntity> siswa;
}
