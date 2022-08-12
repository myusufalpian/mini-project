package com.myusufalpian.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_pelajaran")
public class PelajaranEntity extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(length = 15, name = "nama_pelajaran")
    private String nama;
    @Column(length = 45, name = "jenis_pelajaran")
    private String jenis;
    @OneToOne(cascade = {CascadeType.ALL})
    @JsonIgnore
    private GuruEntity guru;
}