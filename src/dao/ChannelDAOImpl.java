package dao;

import common.DBManager;
import dto.ChannelDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChannelDAOImpl implements ChannelDAO{
    @Override
    public int insertChannel(ChannelDTO channelDTO) {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 1;
        String sql = "insert into channel (channel_id, channel_name, class_id) values (?,?,?)";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, channelDTO.getChannel_id());
            ps.setString(2,channelDTO.getChannel_name());
            ps.setLong(3, channelDTO.getClass_id());
            result =  ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("전체 검색에 예외가 발생했습니다. 다시 조회해주세요");
        }
        finally {
            DBManager.releaseConnection(con, ps);
        }
        return result;
    }

    @Override
    public List<ChannelDTO> selectAllChannel() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ChannelDTO> list = new ArrayList<>();
        String sql = "select * from channel";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChannelDTO dto = new ChannelDTO(rs.getLong(1),rs.getString(2),rs.getLong(3));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("전체 검색에 예외가 발생했습니다. 다시 조회해주세요");
        }
        finally {
            DBManager.releaseConnection(con, ps, rs);
        }
        return list;
    }

    @Override
    public int deleteChannel(ChannelDTO channelDTO) {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 1;
        String sql = "delete from channel where channel_id = ?";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, channelDTO.getChannel_id());
            result =  ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("전체 검색에 예외가 발생했습니다. 다시 조회해주세요");
        }
        finally {
            DBManager.releaseConnection(con, ps);
        }
        return result;
    }

    @Override
    public int updateChannel(ChannelDTO channelDTO) {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 1;
        String sql = "update channel set channel_name = ?, class_id = ? where channel_id = ?";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, channelDTO.getChannel_name());
            ps.setLong(2,channelDTO.getClass_id());
            result =  ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("업데이트에 예외가 발생했습니다. 다시 시도해주세요");
        }
        finally {
            DBManager.releaseConnection(con, ps);
        }
        return result;
    }
}