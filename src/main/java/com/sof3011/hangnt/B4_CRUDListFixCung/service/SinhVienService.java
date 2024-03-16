package com.sof3011.hangnt.B4_CRUDListFixCung.service;

import com.sof3011.hangnt.B4_CRUDListFixCung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    private List<SinhVien> lists = new ArrayList<>();

    public SinhVienService() {
        // fake data => khoi tao luon trong contructor
        lists.add(new SinhVien("HANGNT169", 19, "Ha Noi", true, "Nguyen Thuy Hang"));
        lists.add(new SinhVien("LINHMTPH39724", 19, "Ha Noi", true, "Mai Thuy Linh"));
        lists.add(new SinhVien("NGUYENVV44", 19, "Ha Noi", false, "VU NGUYEN"));
        lists.add(new SinhVien("HANGNgdfsgT169", 19, "Ha Noi", true, "Nguyen Thuy Hang"));
        lists.add(new SinhVien("HANGNsgfdT169", 19, "Ha Noi", true, "Nguyen Thuy Hang"));
    }

    public List<SinhVien> getAll() {
        return lists;
    }

    public void xoaSinhVien(int index) {
        lists.remove(index);
    }

    public SinhVien detailSinhVien(int index) {
        return lists.get(index);
    }

    public void addSinhVien(SinhVien sv) {
        lists.add(sv);
    }
}
