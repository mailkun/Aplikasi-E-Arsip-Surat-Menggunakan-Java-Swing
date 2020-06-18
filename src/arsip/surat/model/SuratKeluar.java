/*
 * The MIT License
 *
 * Copyright 2020 Universitas Teknologi Yogyakarta.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package arsip.surat.model;

import java.util.Date;

/**
 *
 * @author MAILUN
 */
public class SuratKeluar {
    
    private int id_surat_keluar;
    private String no_agenda;
    private String no_surat;
    private Date tgl_surat;
    private String lampiran;
    private String perihal;
    private String tembusan;
    private String tujuan_surat;
    private byte[] file_surat;
    private int id_user;

    public SuratKeluar() {
    }

    public SuratKeluar(int id_surat_keluar, String no_agenda, String no_surat, Date tgl_surat, String lampiran, String perihal, String tembusan, String tujuan_surat, byte[] file_surat, int id_user) {
        this.id_surat_keluar = id_surat_keluar;
        this.no_agenda = no_agenda;
        this.no_surat = no_surat;
        this.tgl_surat = tgl_surat;
        this.lampiran = lampiran;
        this.perihal = perihal;
        this.tembusan = tembusan;
        this.tujuan_surat = tujuan_surat;
        this.file_surat = file_surat;
        this.id_user = id_user;
    }

    public int getId_surat_keluar() {
        return id_surat_keluar;
    }

    public void setId_surat_keluar(int id_surat_keluar) {
        this.id_surat_keluar = id_surat_keluar;
    }

    public String getNo_agenda() {
        return no_agenda;
    }

    public void setNo_agenda(String no_agenda) {
        this.no_agenda = no_agenda;
    }

    public String getNo_surat() {
        return no_surat;
    }

    public void setNo_surat(String no_surat) {
        this.no_surat = no_surat;
    }

    public Date getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(Date tgl_surat) {
        this.tgl_surat = tgl_surat;
    }

    public String getLampiran() {
        return lampiran;
    }

    public void setLampiran(String lampiran) {
        this.lampiran = lampiran;
    }

    public String getPerihal() {
        return perihal;
    }

    public void setPerihal(String perihal) {
        this.perihal = perihal;
    }

    public String getTembusan() {
        return tembusan;
    }

    public void setTembusan(String tembusan) {
        this.tembusan = tembusan;
    }

    public String getTujuan_surat() {
        return tujuan_surat;
    }

    public void setTujuan_surat(String tujuan_surat) {
        this.tujuan_surat = tujuan_surat;
    }

    public byte[] getFile_surat() {
        return file_surat;
    }

    public void setFile_surat(byte[] file_surat) {
        this.file_surat = file_surat;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
