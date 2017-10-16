package cafe.jjdev.web.service;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private String NS = "cafe.jjdev.web.service.BoardMapper.";

	public int updateBoard(Board board) {
		return sqlSessionTemplate.update(NS+"updateBoard", board);
	}

	public int deleteBoard(int boardNo, String boardPw) {
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardPw(boardPw);
		return sqlSessionTemplate.delete(NS+"deleteBoard", board);
	}

	public Board getBoard(int boardNo) {
		return sqlSessionTemplate.selectOne(NS+"getBoard", boardNo);
	}

	public List<Board> getBoardList(int currentPage, int pagePerRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", (currentPage - 1) * pagePerRow);
		map.put("pagePerRow", pagePerRow);
		return sqlSessionTemplate.selectList(NS+"getBoardList", map);
	}

	public int getBoardCount() {
		return sqlSessionTemplate.selectOne(NS+"getBoardCount");
	}

	public int insertBoard(Board board) {
		return sqlSessionTemplate.insert(NS+"insertBoard", board);
	}
}
