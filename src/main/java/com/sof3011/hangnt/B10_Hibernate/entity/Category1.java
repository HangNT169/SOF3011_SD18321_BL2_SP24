package com.sof3011.hangnt.B10_Hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // Danh dau day la thuc the
@Table(name = "category") // ten bang trong SQL muon mapping
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category1 {

    /**
     * J3: JDBC - Java database connectivity
     * => Truy van dung sql
     * J4: Hibenate
     * C1: Truy van cau len SQL
     * C2: Truy van bang HQL(Hibernate Query Language)
     * => Truy van tren thuc the (Truy van tren class)
     * ORM(Object Relationship Mapping):
     * 1 table :
     * + Cac column:
     * + Khoa chinh
     * + Khoa ngoai
     * + cot binh thuong
     */

    @Id // Khoa chinh cua bang
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Ten trong SQL
    private Long id123;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
