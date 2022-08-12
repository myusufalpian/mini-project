package com.myusufalpian.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_jadwal")
public class JadwalEntity extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(length = 8, name = "hari")
    private String hari;
    @Column(length = 10, name = "waktu")
    private String waktu;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pelajaran_id")
    private Set<PelajaranEntity> pelajaran = new HashSet<PelajaranEntity>();
}
