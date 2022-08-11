package com.myusufalpian.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_kelas")
public class KelasEntity extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(length = 15, name = "nama_kelas")
    private String nama;
    @OneToOne(cascade = {CascadeType.ALL})
    private GuruEntity guru;

}
