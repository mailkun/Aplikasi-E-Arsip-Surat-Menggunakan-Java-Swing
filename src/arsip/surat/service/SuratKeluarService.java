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
package arsip.surat.service;

import arsip.surat.dao.SuratKeluarDao;
import arsip.surat.dao.SuratKeluarDataAccessService;
import arsip.surat.model.SuratKeluar;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MAILUN
 */
public class SuratKeluarService {
    
    private static SuratKeluarService suratkeluarService;
    private final SuratKeluarDao suratkeluarDao;
    
    private SuratKeluarService() {
    this.suratkeluarDao = new SuratKeluarDataAccessService();
    }
    
    public static SuratKeluarService getInstance() {
        if (suratkeluarService == null) {
            suratkeluarService = new SuratKeluarService();
        }
        return suratkeluarService;
    }
    
    public int insertSuratKeluar (SuratKeluar suratkeluar) {
        return suratkeluarDao.insertSuratKeluar(suratkeluar);
    }
    
    public int updateSuratKeluarById (int id_surat_keluar, SuratKeluar suratKeluar) {
        return suratkeluarDao.updateSuratKeluarById(id_surat_keluar, suratKeluar);
    }
    
    public int deleteSuratKeluarById (int id_surat_keluar) {
        return suratkeluarDao.deleteSuratKeluarById(id_surat_keluar);
    }
    
    public List<SuratKeluar> selectAllSuratKeluar() {
        return suratkeluarDao.selectAllSuratKeluar();
    }
    
    public Optional<SuratKeluar> selectSuratKeluarById(int id_surat_keluar) {
        return suratkeluarDao.selectSuratKeluarById(id_surat_keluar);
    }
}
