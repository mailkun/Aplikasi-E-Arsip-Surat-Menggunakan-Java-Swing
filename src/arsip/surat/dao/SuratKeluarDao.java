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
package arsip.surat.dao;

import arsip.surat.model.SuratKeluar;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MAILUN
 */
public interface SuratKeluarDao {
    
    /**
     * 
     * @param suratkeluar
     * @return 0=Gagal, 1=Sukses
     */
    int insertSuratKeluar(SuratKeluar suratkeluar);
    
    /**
     * 
     * @param id_surat_keluar
     * @param suratKeluar
     * @return 0=Gagal, 1=Sukses
     */
    int updateSuratKeluarById(int id_surat_keluar, SuratKeluar suratKeluar);
    
    /**
     * 
     * @param id_surat_keluar
     * @return 
     */
    int deleteSuratKeluarById (int id_surat_keluar);
    
    /**
     * 
     * @return 
     */
    List<SuratKeluar> selectAllSuratKeluar();
    
    /**
     * 
     * @param id_surat_keluar
     * @return 
     */
    Optional<SuratKeluar> selectSuratKeluarById(int id_surat_keluar);
}
