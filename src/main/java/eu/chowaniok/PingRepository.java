package eu.chowaniok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by marek on 06/11/14.
 */
@Repository
public class PingRepository {

    @Autowired
    protected JdbcTemplate jdbc;


    public List<Map<String, Object>> getPings() {
        return jdbc.queryForList("select * from Pings", userMapper);
    }

    public Ping getPing(long id) {
        return jdbc.queryForObject("SELECT * FROM pings WHERE id=?", userMapper, id);
    }

    private static final RowMapper<Ping> userMapper = new RowMapper<Ping>() {
        public Ping mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ping ping = new Ping(rs.getLong("id"), rs.getInt("year"), rs.getInt("month"), rs.getInt("day"), rs.getInt("hour"), rs.getInt("minute"));
            return ping;
        }
    };

    public int save(Ping ping) {
        int result = jdbc.update("INSERT INTO pings(year,month,day, hour, minute) values(?,?,?,?,?)",
            ping.getYear(), ping.getMonth(), ping.getDay(), ping.getHour(), ping.getMinute());
        return result;
    }
}
