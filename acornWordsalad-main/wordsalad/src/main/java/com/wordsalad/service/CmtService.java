package com.wordsalad.service;

import com.wordsalad.dto.CmtDto;
import com.wordsalad.entity.Cmtinfo;
import com.wordsalad.repository.CmtRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional // 데이터를 불러와서 db에 넣고 실행이 끝나면 모든 작업들을 원상태로 되돌릴 수 있다. 안쓰는곳엔 (readOnly=true)
@RequiredArgsConstructor
public class CmtService {

	private final CmtRepository cmtRepository;

	public List<CmtDto> getcmtInfo(int postnum) {
		List<Cmtinfo> cmtSingle = cmtRepository.findAll();
		List<CmtDto> cmtDtoAll = new ArrayList<CmtDto>();

		for (Cmtinfo cmt : cmtSingle) {
			CmtDto cmtListDto = new CmtDto(
					cmt.getCOMMENT_SEQ(),
					cmt.getPOSTNUMBER(),
					cmt.getCOMMENTCONTENTS(),
					cmt.getID(),
					cmt.getCOMMENTDATE(),
					cmt.getCOMMENTLIKE(),
					cmt.getCOMMENTHATE());
			if (cmt.getPOSTNUMBER() == postnum)
				cmtDtoAll.add(cmtListDto);
		}
		return cmtDtoAll;	
	}

	public void newComment(HttpServletRequest req , int postnum, String date, String cmtcontents) {

		Cmtinfo cmt = new Cmtinfo();
		
		String id = req.getSession().getAttribute("id").toString();

		cmt.setPOSTNUMBER(postnum);
		cmt.setID(id);
		cmt.setCOMMENTCONTENTS(cmtcontents);
		cmt.setCOMMENTDATE(date);
		
		cmtRepository.save(cmt);
	}
}
