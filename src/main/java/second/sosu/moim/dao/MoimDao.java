package second.sosu.moim.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import second.sosu.common.dao.AbstractDAO;
import second.sosu.common.domain.CommandMap;

@Repository("moimDao")
public class MoimDao extends AbstractDAO {

	// 모임리스트
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> moimList(Map<String, Object> map, HttpSession session, CommandMap commandMap)
			throws Exception {

		List<Map<String, Object>> moimList = (List<Map<String, Object>>) selectList("moim.moimList", map);

		// 스크랩 유무
		if (session.getAttribute("M_IDX") != null) {

			for (int i = 0; i < moimList.size(); i++) {

				Map<String, Object> moimZzim = new HashMap<>();
				moimZzim.put("M_IDX", session.getAttribute("M_IDX"));
				moimZzim.put("MO_IDX", moimList.get(i).get("MO_IDX"));

				Map<String, Object> zz = (Map<String, Object>) selectOne("moim.moimZzimCheck", moimZzim);

				moimList.get(i).put("MZ_CHECK", zz.get("MZ_CHECK"));
			}

		}

		// 모임 현재 멤버 수
		for (int i = 0; i < moimList.size(); i++) {
			Map<String, Object> moimMemCount = (Map<String, Object>) selectOne("moim.moimMemberCount",
					moimList.get(i).get("MO_IDX"));
			moimList.get(i).put("MOMEM_COUNT", moimMemCount.get("MOMEM_COUNT"));
		}
		// 모임 스크랩 수
		for (int i = 0; i < moimList.size(); i++) {

			Map<String, Object> moimZzimCount = (Map<String, Object>) selectOne("moim.moimZzimCount",
					moimList.get(i).get("MO_IDX"));
			moimList.get(i).put("MZ_COUNT", moimZzimCount.get("MZ_COUNT"));
		}

		return moimList;
	}

	// 모임 갯수
	@SuppressWarnings("unchecked")
	public Map<String, Object> moimCount(Map<String, Object> map) throws Exception {
		Map<String, Object> moimCount = (Map<String, Object>) selectOne("moim.moimCount", map);
		return moimCount;
	}

	// 모임 상세보기
	@SuppressWarnings("unchecked")
	public Map<String, Object> moimDetail(Map<String, Object> map) throws Exception {
		Map<String, Object> moimDetail = (Map<String, Object>) selectOne("moim.moimDetail", map);

		Map<String, Object> moimMemCount = (Map<String, Object>) selectOne("moim.moimMemberCount",
				moimDetail.get("MO_IDX"));
		moimDetail.put("MOMEM_COUNT", moimMemCount.get("MOMEM_COUNT"));
		return moimDetail;
	}

	// 모임 상세 이미지
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectMoimImg(Map<String, Object> map, CommandMap commandMap) throws Exception {

		return selectList("moim.selectMoimImg", map);
	}

	// 모임에 참가한 인원 리스트
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> moimMemberList(Map<String, Object> map, CommandMap commandMap) throws Exception {

		List<Map<String, Object>> moimMemberList = (List<Map<String, Object>>) selectList("moim.moimMemberList", map);

		// 프사
		for (int i = 0; i < moimMemberList.size(); i++) {
			Map<String, Object> memberProfile = (Map<String, Object>) selectOne("file.memberProfile",
					moimMemberList.get(i).get("M_IDX"));
			moimMemberList.get(i).put("PROFILE", memberProfile.get("PROFILE"));
		}

		return moimMemberList;
	}

	// 모임에 대기중인 인원 리스트
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> moimMemberWait(Map<String, Object> map, CommandMap commandMap) throws Exception {

		List<Map<String, Object>> moimMemberWait = (List<Map<String, Object>>) selectList("moim.moimMemberWait", map);

		// 프사
		for (int i = 0; i < moimMemberWait.size(); i++) {
			Map<String, Object> memberProfile = (Map<String, Object>) selectOne("file.memberProfile",
					moimMemberWait.get(i).get("M_IDX"));
			moimMemberWait.get(i).put("PROFILE", memberProfile.get("PROFILE"));
		}

		return moimMemberWait;
	}

	// 모임에서 강퇴당한 인원 리스트
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> moimMemberBanList(Map<String, Object> map, CommandMap commandMap)
			throws Exception {

		List<Map<String, Object>> moimMemberBanList = (List<Map<String, Object>>) selectList("moim.moimMemberBanList",
				map);

		return moimMemberBanList;
	}

	// 모임 참여 승인
	public void moimWaitApprove(Map<String, Object> map) throws Exception {
		update("moim.moimWaitApprove", map);
	}

	// 모임 맴버 강퇴
	public void moimMemberBan(Map<String, Object> map) throws Exception {
		update("moim.moimMemberBan", map);
	}

	// 모임 작성
	public void moimRegister(Map<String, Object> map, HttpSession seesion) throws Exception {
		insert("moim.moimRegister", map);
	}

	// 모임 상세 이미지 등록
	public void moimImg(Map<String, Object> map) throws Exception {
		insert("file.imgInsert", map);
	}

	// 모임 수정
	public void moimModify(Map<String, Object> map) throws Exception {
		update("moim.moimModify", map);
	}

	// 모임 이미지 삭제
	public void MoimImgDelete(String F_SVNAME) throws Exception {
		update("file.FileDelete", F_SVNAME);
	}

	// 모임 삭제
	public void moimDelete(Map<String, Object> map) throws Exception {
		update("moim.moimDelete", map);
	}

	// 모임 참가 (요청이 필요하지 않은 경우)
	public void moimJoin(Map<String, Object> map, HttpSession seesion, CommandMap commandMap) throws Exception {
		insert("moim.moimJoin", map);
	}

	// 모임 참가 요청 (요청이 필요하지 않은 경우)
	public void moimJoinPermit(Map<String, Object> map, HttpSession seesion, CommandMap commandMap) throws Exception {
		insert("moim.moimJoinPermit", map);
	}

	// 모임 조기 마감
	public void moimSelfClose(Map<String, Object> map) throws Exception {
		update("moim.moimSelfClose", map);
	}

	// 모임 자동 마감
	public void moimClose() throws Exception {
		update2("moim.moimClose");
	}

	// 모임 탈퇴하기
	public void moimExit(Map<String, Object> map) throws Exception {
		update("moim.moimExit", map);
	}

}