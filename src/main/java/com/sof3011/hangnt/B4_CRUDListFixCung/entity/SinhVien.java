package com.sof3011.hangnt.B4_CRUDListFixCung.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // contructor full ts
@NoArgsConstructor  // contructor k ts
@Builder            // Tao contructor tuy y
//@Data // nang => k khac gi import *
public class SinhVien {

    private String mssv;

    private int tuoi;

    private String diaChi;

    private boolean gioiTinh;

    private String ten;

}
