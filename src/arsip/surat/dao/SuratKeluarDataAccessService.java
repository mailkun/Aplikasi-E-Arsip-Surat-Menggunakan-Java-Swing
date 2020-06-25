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
import arsip.surat.util.ConnectionUtil;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementasi dari interfaec SuratKeluarDao
 * @author MAILUN
 */
public class SuratKeluarDataAccessService implements SuratKeluarDao {
    
    private Connection connection;
    public static List<SuratKeluar> DB = new ArrayList<>();
    
    
    @Override
    public int insertSuratKeluar(SuratKeluar suratkeluar) {
        connection = ConnectionUtil.getConnection();
        final String sql = "CALL insert_suratkeluar(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareCall(sql)) {
            ps.setInt(1, suratkeluar.getId_surat_keluar());
            ps.setInt(2, suratkeluar.getId_user());
            ps.setString(3, suratkeluar.getNo_agenda());
            ps.setString(4, suratkeluar.getNo_surat());
            ps.setDate(5, (Date) suratkeluar.getTgl_surat());
            ps.setString(6, suratkeluar.getLampiran());
            ps.setString(7, suratkeluar.getPerihal());
            ps.setString(8, suratkeluar.getTembusan());
            ps.setString(9, suratkeluar.getTujuan_surat());
            ps.setBinaryStream(10, new ByteArrayInputStream( suratkeluar.getFile_surat() ), suratkeluar.getFile_surat().length);
            ps.executeUpdate();
            DB.add(suratkeluar);
            connection.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(SuratKeluarDataAccessService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }   
    }

    @Override
    public int updateSuratKeluarById(int id_surat_keluar, SuratKeluar suratkeluar) {
        return selectSuratKeluarById(id_surat_keluar)
                .map((SuratKeluar oldSuratKeluar) -> {
                    int indexOfSuratKeluar = DB.indexOf(oldSuratKeluar);
                    if (indexOfSuratKeluar >= 0) {
                        connection = ConnectionUtil.getConnection();
                        final String sql = "CALL update_suratkeluar(?,?,?,?,?,?,?,?,?,?,?)";
                        try (PreparedStatement ps = connection.prepareCall(sql)) {
                            ps.setInt(1, id_surat_keluar);
                            ps.setInt(2, suratkeluar.getId_surat_keluar());
                            ps.setInt(3, suratkeluar.getId_user());
                            ps.setString(4, suratkeluar.getNo_agenda());
                            ps.setString(5, suratkeluar.getNo_surat());
                            ps.setDate(6, (Date) suratkeluar.getTgl_surat());
                            ps.setString(7, suratkeluar.getLampiran());
                            ps.setString(8, suratkeluar.getPerihal());
                            ps.setString(9, suratkeluar.getTembusan());
                            ps.setString(10, suratkeluar.getTujuan_surat());
                            ps.setBinaryStream(11, new ByteArrayInputStream( suratkeluar.getFile_surat() ), suratkeluar.getFile_surat().length);
                            ps.executeUpdate();
                            DB.set(indexOfSuratKeluar, suratkeluar);
                            connection.close();
                            return 1;
                        } catch (SQLException ex) {
                            Logger.getLogger(SuratKeluarDataAccessService.class.getName()).log(Level.SEVERE, null, ex);
                            return 0;
                        }
                    }
                    return 0;
        })
                .orElse(0);
    }

    @Override
    public int deleteSuratKeluarById(int id_surat_keluar) {
        Optional<SuratKeluar> selectSuratKeluar = selectSuratKeluarById(id_surat_keluar);
        if (selectSuratKeluar.isPresent()) {
            connection = ConnectionUtil.getConnection();
            final String sql = "CALL delete_suratkeluar(?)";
            try (PreparedStatement ps = connection.prepareCall(sql)) {
                ps.setInt (1, id_surat_keluar);
                ps.executeUpdate();
                DB.remove(selectSuratKeluar.get());
                connection.close();
                return 1;
            }catch (SQLException ex) {
                Logger.getLogger(SuratKeluarDataAccessService.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        }
        return 0;
    }

    @Override
    public List<SuratKeluar> selectAllSuratKeluar() {
        DB.clear();
        connection = ConnectionUtil.getConnection();
        final String sql = "SELECT * FROM suratkeluar";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){ 
            Blob file_surat_blob = resultSet.getBlob("file_surat");
            byte file_surat_byte[];
            if (file_surat_blob != null) {
                    file_surat_byte = file_surat_blob.getBytes(1l, (int) file_surat_blob.length());
                } else {
                	file_surat_byte = null;
                    }
                SuratKeluar suratKeluar = new SuratKeluar(
                        resultSet.getInt("id_surat_keluar"),
                        resultSet.getString("no_agenda"),
                        resultSet.getString("no_surat"),
                        resultSet.getDate("tgl_surat"),
                        resultSet.getString("lampiran"),
                        resultSet.getString("perihal"),
                        resultSet.getString("tembusan"),
                        resultSet.getString("tujuan_surat"),
                        file_surat_byte,
                        resultSet.getInt("id_user")
                );
                DB.add(suratKeluar);
               }
        } catch (SQLException ex) {
          Logger.getLogger(BidangDataAccessService.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return DB;
    }

    @Override
    public Optional<SuratKeluar> selectSuratKeluarById(int id_surat_keluar) {
        return DB.stream()
                .filter(suratkeluar -> suratkeluar.getId_surat_keluar() == (id_surat_keluar))
                .findFirst();
    }  
}
