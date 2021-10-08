package egovframework.ag.homepage.kofacollection.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.ag.common.utils.StringUtils;
import egovframework.ag.common.view.DownloadView;
import egovframework.ag.common.vo.CommonListVO;
import egovframework.ag.common.web.ParamMap;
import egovframework.ag.homepage.kofacollection.service.KfCollectionService;
import egovframework.ag.homepage.kofacollection.vo.CollectionPagingVo;
import egovframework.ag.homepage.kofacollection.vo.KmdbCollectionsVO;

/***********************************************************************************************************************************
 * @class name : KofaCollectionController.java
 * @author : 이소정
 * @create date : 2021-09-09
 * @package name : egovframework.ag.homepage.kofacollection.web
 * @version : v1.0
 * @description : kofacollectionList 관리를 위한 클래스
 * @history :
 *          =================================================================================
 *          DATE NAME DESCRIPTION
 *          ---------------------------------------------------------------------------------------------------------------------------------
 *          2021.09.09 이소정 First Generated
 *************************************************************************************************************************************/

/*
 * : album 형태 : http://localhost:8082/collectionlist/detailGrid : list 형태 :
 * http://localhost:8082/collectionlist/detailList : list 형태
 */
@Controller
@RequestMapping("/collectionlist")
public class KofaCollectionController {

	@Autowired
	private KfCollectionService colService;

	// out.clear();
	// out = pageContext.pushBody();
	/*
	 * [2021-09-09] 소명소프트 by 이소정 example :
	 * http://localhost:8082/collectionlist/collectionGroup
	 * 
	 * @return 화면 ID : UID_KMDB_KOFA_001 컬렉션 그룹명, 신규 컬렉션, 추천 컬렉션 목록 불러오기(level1)
	 * 
	 */

	// index 로 데이터 select

	@RequestMapping("/collectionGroup")
    public String collectionGroup(HttpServletRequest request, HttpServletResponse response, ParamMap paramMap,
            Model model) throws Exception {
        // model.addAttribute("colName",colService.selectColName(paramMap.getMap()));
        // String idx = request.getParameter("idx");
        HashMap<String, Object> searchKeyword = null;
        searchKeyword = new HashMap<String, Object>();
        String colId = request.getParameter("colId");
        String upperColId = request.getParameter("upperColId");
 
        searchKeyword.put("colId", colId);
        searchKeyword.put("upperColId", upperColId);
 
        List<KmdbCollectionsVO> collectionGroupName = colService.selectColName(searchKeyword);
        List<KmdbCollectionsVO> newCollectionName = colService.selectNewName(searchKeyword);
        List<KmdbCollectionsVO> bestCollectionName = colService.selectBestName(searchKeyword);
 
        model.addAttribute("colId",colId);
        model.addAttribute("collectionGroupName", collectionGroupName);
        model.addAttribute("newCollectionName", newCollectionName);
        model.addAttribute("bestCollectionName", bestCollectionName);
 
        return "/kofa/collectionMain";
    }

	/*
	 * [2021-09-09] 소명소프트 by 이소정 색인 기능 ( 색인 idx 클릭시 해당 idx에 대한 데이터를 가져옵니다) example :
	 * http://localhost:8082/collectionlist/detail/List
	 * 
	 * @return 화면 ID : UID_KMDB_KOFA_002_02 상세컬렉션 리스트형(level2)
	 * 
	 */
	@RequestMapping("/detail/List")
	public String detailList(HttpServletRequest request, HttpServletResponse response, ParamMap paramMap, Model model,
			CollectionPagingVo cPagingVo, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		// model.addAttribute("colName",colService.selectColName(paramMap.getMap()));
		HashMap<String, Object> searchKeyWord = null;
		searchKeyWord = new HashMap<String, Object>();

		String sortMethod = request.getParameter("sortMethod"); // 정렬 값을 받아옵니다 ex) 업데이트 순 , 제목순
		// null point exception 방지 !
		if (sortMethod == null) {
			sortMethod = "";
		}
		
		String idx = request.getParameter("idx"); // 색인 값을 받아옵니다.
		// idx 가 빈값일 경우 !
		if (idx == null) {
			idx = "";
		}

		String upperColId = request.getParameter("upperColId");

		searchKeyWord.put("upperColId", upperColId);
		searchKeyWord.put("idx", idx);

		// idx 값으로 데이터를 가져옵니다 ( 색인 )

		List<KmdbCollectionsVO> kofaGroupDesc = colService.selectKofaGroupDesc(searchKeyWord); // 컬렉션 해제 ( 설명 )
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		

		// etc 버튼 클릭시 (기타 버튼)
		if (idx.equals("etc")) {
			int totalIdxEtx = colService.getDataByIdxEtcCount(upperColId);
			cPagingVo = new CollectionPagingVo(totalIdxEtx, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			searchKeyWord = new HashMap<String, Object>();
			searchKeyWord.put("upperColId", upperColId);
			searchKeyWord.put("idx", idx);
			searchKeyWord.put("start", cPagingVo.getStart());
			searchKeyWord.put("end", cPagingVo.getEnd());
			searchKeyWord.put("sortMethod", sortMethod);

			List<KmdbCollectionsVO> getDataByEtc = colService.getDataByIdxEtc(searchKeyWord);
			model.addAttribute("getDataByEtc", getDataByEtc);
			model.addAttribute("upperColId", upperColId);
			model.addAttribute("sortMethod", sortMethod);
			model.addAttribute("cPagingVo", cPagingVo);
			model.addAttribute("idx", idx);
			
		} else if(idx.equals("all")) { //전체(idx==all)
			int total = colService.defaultListCount(upperColId);
			cPagingVo = new CollectionPagingVo(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			searchKeyWord = new HashMap<String, Object>();
			searchKeyWord.put("upperColId", upperColId);
			searchKeyWord.put("idx", idx);
			
			searchKeyWord.put("start", cPagingVo.getStart());
			searchKeyWord.put("end", cPagingVo.getEnd());
			searchKeyWord.put("sortMethod", sortMethod);
			List<KmdbCollectionsVO> DataByAll = colService.getDataByIdxAll(searchKeyWord);
			
			model.addAttribute("DataByAll", DataByAll);
			model.addAttribute("upperColId", upperColId);
			model.addAttribute("sortMethod", sortMethod);
			model.addAttribute("cPagingVo", cPagingVo);
			model.addAttribute("idx", idx);
		}else {// ㄱ~ㅎ 버튼 클릭시 or 기본 default 값일때 ("")
			
			searchKeyWord = new HashMap<String, Object>();
			searchKeyWord.put("upperColId", upperColId);
			searchKeyWord.put("idx", idx);
			int totalIdx = colService.getDataByIdxCount(searchKeyWord);
			cPagingVo = new CollectionPagingVo(totalIdx, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			
			searchKeyWord.put("start", cPagingVo.getStart());
			searchKeyWord.put("end", cPagingVo.getEnd());
			searchKeyWord.put("sortMethod", sortMethod);
			
			List<KmdbCollectionsVO> getData = colService.getDataByIdx(searchKeyWord);
			model.addAttribute("getData", getData);
			model.addAttribute("upperColId", upperColId);
			model.addAttribute("sortMethod", sortMethod);
			model.addAttribute("cPagingVo", cPagingVo);
			model.addAttribute("idx", idx);
		}
	
		model.addAttribute("kofaGroupDesc", kofaGroupDesc);
	
		return "/kofa/collectionList";
	}

	/*
	 * [2021-09-09] 소명소프트 by 이소정 example :
	 * http://localhost:8082/collectionlist/detail/Album
	 * 
	 * @return 화면 ID : UID_KMDB_KOFA_002_01 상세컬렉션 앨범형(level2)
	 * 
	 */
	@RequestMapping("/detail/Album")
	public String detailAlbumList(HttpServletRequest request, HttpServletResponse response, ParamMap paramMap,
			Model model) throws Exception {
		String colId = request.getParameter("colId");
		HashMap<String, Object> searchKeyWord = null;
		searchKeyWord = new HashMap<String, Object>();

		searchKeyWord.put("colId", colId);
		searchKeyWord.put("collectionId", colId);

		List<KmdbCollectionsVO> collectionName = colService.collectionName(searchKeyWord);
		for (int i = 0; i < collectionName.size(); i++) {
			System.out.println("colName ===>  " + collectionName.get(i));
		}
		List<KmdbCollectionsVO> kofaGroupDesc = colService.selectKofaGroupDesc(searchKeyWord);
		List<KmdbCollectionsVO> detailAlbumUpdate = colService.selectDetailAlbumUpdate(searchKeyWord);
		List<KmdbCollectionsVO> detailAlbumAbc = colService.selectDetailAlbumAbc(searchKeyWord);

		model.addAttribute("collectionName", collectionName);
		model.addAttribute("kofaGroupDesc", kofaGroupDesc);
		model.addAttribute("detailAlbumUpdate", detailAlbumUpdate);
		model.addAttribute("detailAlbumAbc", detailAlbumAbc);

		return "/kofa/collectionGrid";
	}

	/*
	 * [2021-09-09] 소명소프트 by 이소정 example :
	 * http://localhost:8082/collectionlist/detail/view
	 * 
	 * @return 화면 ID : UID_KMDB_KOFA_003 상세컬렉션 상세뷰(level34)
	 * 
	 */
	@RequestMapping("/detail/view")
	public String detailView(HttpServletRequest request, HttpServletResponse response ,ParamMap paramMap, Model model
			, CollectionPagingVo cPagingVo, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		String colId = request.getParameter("colId");
		HashMap<String, Object> searchKeyWord = null;
		searchKeyWord = new HashMap<String, Object>();
		
		searchKeyWord.put("colId", colId);
		
		
		List<KmdbCollectionsVO> detailView = colService.selectDetailView(searchKeyWord);
		
		//자료에 따른 분류
		List<KmdbCollectionsVO> dataClass = colService.selectDataClass(searchKeyWord);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		}else if (nowPage == null) {
			nowPage = "1";
		}else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		int total = colService.selectDetailDataListCount(colId);
		cPagingVo = new CollectionPagingVo(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		try{
			searchKeyWord = new HashMap<String, Object>();
			searchKeyWord.put("start", cPagingVo.getStart());
			searchKeyWord.put("end", cPagingVo.getEnd());
			searchKeyWord.put("colId", colId);
			List<KmdbCollectionsVO> detailDataList = colService.selectDetailDataList(searchKeyWord);
		
			model.addAttribute("detailDataList",detailDataList);
			searchKeyWord.put("colId", colId);
		} catch (Exception e) {
		}
		
		model.addAttribute("detailView",detailView);
		model.addAttribute("cPagingVo",cPagingVo);
		model.addAttribute("colId",colId);
		model.addAttribute("dataClass", dataClass);
		
		return "/kofa/detailView";
	}
	
	
	/**
	 * @desc 자료에 따른 분류 데이터 가져오기 
	 * @param req
	 * @return json object
	 * @throws Exception 
	 * 
	 */
	
	@RequestMapping("/getClassification")
	@ResponseBody
	public List<KmdbCollectionsVO> getClassification (HttpServletRequest req) throws Exception{
		HashMap<String, Object> searchKeyWord = null;
		searchKeyWord = new HashMap<String, Object>();
		String codeNm = req.getParameter("codeNm");
		String colId = req.getParameter("colId");
		searchKeyWord.put("codeNm", codeNm);
		searchKeyWord.put("colId", colId);
		
		List<KmdbCollectionsVO> result = colService.getPagingData(searchKeyWord);
		
		
		return result;
		
	}
	/**
	 * @desc ajax 데이터 / 페이징 처리 하기
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDetailDataList")
	@ResponseBody
	public Map<String, Object> getDetailDataList(@RequestParam(required = false ,value = "sort1[]") List<String> sort1,
												 @RequestParam(required = false ,value = "sort2[]") List<String> sort2,
												 @RequestParam(required = false ,value = "sort3[]") List<String> sort3,
												 @RequestParam(required = false ,value = "sort4[]") List<String> sort4,
												 @RequestParam(required = false ,value = "sort5[]") List<String> sort5,
		HttpServletRequest request, Model model) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> searchMap = null;
		List<HashMap<String , Object>> pagingDataAjax = null;
		try {
		searchMap = new HashMap<String, Object>();
			
		String colId = request.getParameter("colId");
		String nowPage = request.getParameter("nowPage"); // 현재 페이지
		String cntPerPage = request.getParameter("cntPerPage"); // page당 보여줄 data 갯수
		searchMap.put("colId", colId);
		
		
		/*
		 * for(int i = 0 ; i < keyWord.size();i++) {
		 * searchMap.put("sort"+i,keyWord.get(i)); }
		 */
//		searchMap.put("sort1", sort1);
//		searchMap.put("sort2", sort2);
//		searchMap.put("sort3", sort3);
//		searchMap.put("sort4", sort4);
//		searchMap.put("sort5", sort5);
		//searchMap.put("sort", keyWord);
		searchMap.put("sort1",sort1); //분류체계 list 1 
		searchMap.put("sort2",sort2); //분류체계 list 2
		searchMap.put("sort3",sort3); //분류체계 list 3
		searchMap.put("sort4",sort4); //분류체계 list 4
		searchMap.put("sort5",sort5); //분류체계 list 5
		
		
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		}
		//dead point 
		int totalDataCount = colService.totalDataCount(searchMap);
		CollectionPagingVo vo = new CollectionPagingVo(totalDataCount, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
			searchMap.put("start", vo.getStart());// -> 쿼리에서 쓸 시작
			searchMap.put("end", vo.getEnd());// -> 쿼리에서 쓸 end
			searchMap.put("colId", colId);
			pagingDataAjax = colService.getPagingDataAjax(searchMap);
			//dead point 
			//resultMap.put("result", colService.getPagingData(searchMap));
			resultMap.put("startPage", vo.getStartPage());
			resultMap.put("nowPage", vo.getNowPage());
			resultMap.put("cntPerPage", vo.getCntPerPage());
			resultMap.put("endPage", vo.getEndPage());
			resultMap.put("lastPage", vo.getLastPage());
			resultMap.put("result", pagingDataAjax);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * @desc 데이터를 list 형태로 가져온다.
	 * @param commandMap
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	// 문제 : null 값이면 무조건 사망 고쳐야함
	@RequestMapping("detailList")
	public ModelAndView detailList(@RequestParam HashMap<String, Object> commandMap, ParamMap paramMap,
			HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {

		HashMap<String, Object> searchKeyWord = null;
		searchKeyWord = new HashMap<String, Object>();

		String colId = request.getParameter("colId");

		searchKeyWord.put("colId", colId);
		String sortCheckBox = "";
		System.out.println("detailList() ! ");

		List<KmdbCollectionsVO> detailView = colService.selectDetailView(searchKeyWord);
		// 자료에 따른 분류
		List<KmdbCollectionsVO> dataClass = colService.selectDataClass(searchKeyWord);
		/**
		 * @date [2021-09-30 주환작성]
		 * @desc 분류체계가 , , , , ,로 들어오면 ,를 기준으로 문자열 정리 ( 자르기 )
		 */
		// sort1 분류 값!
		List<Object> sortList1 = new ArrayList<Object>();
		// sort2 분류 값!
		List<Object> sortList2 = new ArrayList<Object>();
		// sort3 값!
		List<Object> sortList3 = new ArrayList<Object>();
		// sort4 값!
		List<Object> sortList4 = new ArrayList<Object>();
		// sort5 값!
		List<Object> sortList5 = new ArrayList<Object>();
		ModelAndView mv = new ModelAndView();

		try {
			// 분류체계 sort1

			KmdbCollectionsVO sortCheckBox1 = colService.sortCheckBox(searchKeyWord);
			String sort1 = null;
			if (sortCheckBox1 == null) {
				sort1 = ",";
			} else {
				sort1 = sortCheckBox1.getSort1();
				String sort1s[] = sort1.split(",");
			
				for (int i = 0; i < sort1s.length; i++) {
					System.out.println(sort1s[i]);
	
					sortList1.add(sort1s[i]);
				}
			}
			mv.addObject("sort1", sortList1); // 분류체계1 !
			System.out.println("sort1 >>>>>>>>>>>>>>" + sortList1);
			// 분류체계 sort2
			KmdbCollectionsVO sortCheckBox2 = colService.sortCheckBox2(searchKeyWord);

			String sort2 = null;
			if (sortCheckBox2 == null) {
				sort2 = ",";
			} else {
				sort2 = sortCheckBox2.getSort2();
				String sort2s[] = sort2.split(",");

				for (int i = 0; i < sort2s.length; i++) {
					System.out.println(sort2s[i]);
					sortList2.add(sort2s[i]);  // 분류체계2 !
				}
			}
			mv.addObject("sort2", sortList2);

			// 분류체계 sort3
			KmdbCollectionsVO sortCheckBox3 = colService.sortCheckBox3(searchKeyWord);
			String sort3 = null;
			if (sortCheckBox3 == null) {
				sort3 = ",";
			} else {
				sort3 = sortCheckBox3.getSort3();
				String sort3s[] = sort3.split(",");

				for (int i = 0; i < sort3s.length; i++) {
					System.out.println(sort3s[i]);
					sortList3.add(sort3s[i]);  // 분류체계2 !
				}
			}
			mv.addObject("sort3", sortList3);


			// 분류체계 sort4
			KmdbCollectionsVO sortCheckBox4 = colService.sortCheckBox4(searchKeyWord);
			String sort4 = null;
			if (sortCheckBox4 == null) {
				sort4 = ",";
			} else {
				sort4 = sortCheckBox4.getSort4();
				String sort4s[] = sort4.split(",");

				for (int i = 0; i < sort4s.length; i++) {
					System.out.println(sort4s[i]);
					sortList4.add(sort4s[i]);  // 분류체계2 !
				}
			}
			mv.addObject("sort4", sortList4);


			// 분류체계 sort5
			KmdbCollectionsVO sortCheckBox5 = colService.sortCheckBox5(searchKeyWord);
			String sort5 = null;
			if (sortCheckBox5 == null) {
				sort5 = ",";
			} else {
				sort5 = sortCheckBox5.getSort5();
				String sort5s[] = sort5.split(",");

				for (int i = 0; i < sort5s.length; i++) {
					System.out.println(sort5s[i]);
					sortList2.add(sort5s[i]);  // 분류체계2 !
				}
			}
			mv.addObject("sort5", sortList5);


		} catch (Exception e) {
			System.out.println(e);
		}

		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		int total = colService.totalDataCount(searchKeyWord);
		
		CollectionPagingVo cPagingVo = new CollectionPagingVo(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		// PageListVo pageListVo =
		// collectionService.selectCollectionAjaxData(searchMap);
		searchKeyWord.put("start", cPagingVo.getStart());// -> 쿼리에서 쓸 시작
		searchKeyWord.put("end", cPagingVo.getEnd());// -> 쿼리에서 쓸 end
		searchKeyWord.put("sortCheckBox", sortCheckBox);
		List<KmdbCollectionsVO> info = colService.selectSorts(searchKeyWord);// sort 1 , sort 2 , sort 3, sort 4 , sort
																				// 5
																				// 데이터를 가져오는 method
		CollectionPagingVo getRelData = colService.selectCollectionAjaxData(searchKeyWord);
		model.addAttribute("info", info);
		model.addAttribute("colId", colId);
		model.addAttribute("Paging", cPagingVo);
		model.addAttribute("cPagingVo", cPagingVo);
		model.addAttribute("detailView", detailView);

		model.addAttribute("dataClass", dataClass); // 자료에 따른 분류
		// model.addAttribute("sortCheckBox", sortCheckBox); //sort 임시
		model.addAttribute("viewAll", colService.getPagingData(searchKeyWord));
		cntPerPage = "10";
		mv.setViewName("/kofa/detailList");
		// "/kofa/detailList"
		return mv;
	}

	/**
	 * @desc 데이터를 앨범 형태로 가져온다.
	 * @param commandMap
	 * @param paramMap
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detailAlbum")
	public String detailAlbum(@RequestParam HashMap<String, Object> commandMap, ParamMap paramMap,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		System.out.println("detailList() ! ");
		HashMap<String, Object> searchMap = null;
		String sort = StringUtils.getStripTag((String) commandMap.get("keyWord"), null);
		searchMap = new HashMap<String, Object>();

		String colId = request.getParameter("colId");
		String sort1 = "";
		String sort2 = "";
		String sort3 = "";
		String sort4 = "";
		String sort5 = "";
		searchMap.put("colId", colId);
		searchMap.put("sort1", sort1);
		searchMap.put("sort2", sort2);
		searchMap.put("sort3", sort3);
		searchMap.put("sort4", sort4);
		searchMap.put("sort5", sort5);
		System.out.println("detailList() ! ");
		String nowPage = request.getParameter("nowPage"); // 현제페이지
		String cntPerPage = request.getParameter("cntPerPage"); // page당 보여줄 data 갯수
		int totalDataCount = colService.totalDataCount(searchMap);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		}
		CollectionPagingVo vo = new CollectionPagingVo(totalDataCount, Integer.parseInt(nowPage),
				Integer.parseInt(cntPerPage));
		// PageListVo pageListVo =
		// collectionService.selectCollectionAjaxData(searchMap);
		searchMap.put("start", vo.getStart());// -> 쿼리에서 쓸 시작
		searchMap.put("end", vo.getEnd());// -> 쿼리에서 쓸 end

		List<KmdbCollectionsVO> info = colService.selectSorts(searchMap);// sort 1 , sort 2 , sort 3, sort 4 , sort 5
																			// 데이터를 가져오는 method
		CollectionPagingVo getRelData = colService.selectCollectionAjaxData(searchMap);
		model.addAttribute("info", info);
		model.addAttribute("colId", colId);
		model.addAttribute("Paging", vo);

		model.addAttribute("startPage", vo.getStartPage()); // startPage
		model.addAttribute("nowPage", vo.getNowPage()); // nowPage
		model.addAttribute("cntPerPage", vo.getCntPerPage()); // cntPerPage
		model.addAttribute("endPage", vo.getEndPage()); // endPage
		model.addAttribute("lastPage", vo.getLastPage()); // lastPage

		model.addAttribute("viewAll", colService.getPagingData(searchMap));
		cntPerPage = "10";

		return "/kofa/dataGrid";
	}

	/**
	 * @desc 데이터를 list Ajax 형태로 return 한다.
	 * @return : ResponseBody 
	 * @throws Exception
	 */
	@RequestMapping("/listAjax")
	@ResponseBody
	public List<KmdbCollectionsVO> returnAjaxData(HttpServletRequest request, HttpServletResponse response, ParamMap paramMap, Model model,
			CollectionPagingVo cPagingVo, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception{
		
		String upperColId = request.getParameter("upperColId");
		HashMap<String, Object> searchKeyWord = null;
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		int total = colService.defaultListCount(upperColId);
		cPagingVo = new CollectionPagingVo(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		try {
			searchKeyWord = new HashMap<String, Object>();
			String sortMethod = request.getParameter("sortMethod");
			searchKeyWord.put("sortMethod", sortMethod);
			searchKeyWord.put("start", cPagingVo.getStart());
			searchKeyWord.put("end", cPagingVo.getEnd());
			searchKeyWord.put("upperColId", upperColId);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		List<KmdbCollectionsVO> returnAjaxList = colService.getDataByIdx(searchKeyWord);
		
		return returnAjaxList;
		
	}
	
	/**
	 * @writer [2021-09-30 재석 작성 ]
	 * @desc kofacollection 사용자 자료 팝업화면 
	 * @return 
	 * @throws Exception
	 * @test => required false 로 해당 파라미터 필수값을 false 를 통해 임시적으로 로직이 실행되는지 test
	 * @test url => http://localhost:8083/collectionlist/itemDetailPop?dataId=136&typeClss=VO&colName=%ED%95%9C%EC%9A%B0%EC%84%AD%E3%86%8D%ED%95%9C%EA%B7%9C%ED%98%B8%20%E7%88%B6%E5%AD%90%20%EC%BB%AC%EB%A0%89%EC%85%98&colId=6
	 */
	
	@RequestMapping("/itemDetailPop")
	public String itemDetailPop(@RequestParam HashMap<String, Object> commandMap,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
		HashMap<String, Object> searchKeyWord = null;
		String colId = request.getParameter("colId");
		String dataId = StringUtils.getStripTag((String) commandMap.get("dataId"), null);
		String typeClss = StringUtils.getStripTag((String) commandMap.get("typeClss"), null);
		String colName = StringUtils.getStripTag((String) commandMap.get("colName"), null);
		String dataNm = StringUtils.getStripTag((String) commandMap.get("dataNm"), null);
		List<KmdbCollectionsVO> relationShipCollectionTitle = null;
		KmdbCollectionsVO getCollectionDataInfo = null;
		// parameter 가 null 값으로 들어올 경우 
		if(colId == null) {
			colId = "";
		}
		if(dataId == null ) {
			dataId = "";
		}
		if(typeClss == null) {
			typeClss ="";
		}
		if(colName == null) {
			colName ="";
		}
		if(dataNm == null) {
			dataNm ="";
		}
		
		
		try {
			
			searchKeyWord = new HashMap<String, Object>();
			searchKeyWord.put("dataId", dataId);
			searchKeyWord.put("typeClss", typeClss);
			searchKeyWord.put("colName", colName);
			searchKeyWord.put("dataId", dataId);
			searchKeyWord.put("dataNm", dataNm);
			
			
		if (typeClss.equals("VI")) {// 비디오
					getCollectionDataInfo = colService.getCollectionDataInfoVI(searchKeyWord); // 컬렉션 자료유형 VI 데이터 정보

		} else if (typeClss.equals("TH")) { // 학위 , 논문
					getCollectionDataInfo = colService.getCollectionDataInfoTH(searchKeyWord); // 컬렉션 자료유형 TH 데이터 정보
		
		} else if (typeClss.equals("VO")) { // 정기간행물
					getCollectionDataInfo = colService.getCollectionDataInfoVO(searchKeyWord); // 컬렉션 자료유형 VO 데이터 정보
		
		} else if (typeClss.equals("SF")) { // 스틸필름
					getCollectionDataInfo = colService.getCollectionDataInfoSF(searchKeyWord); // 컬렉션 자료유형 SF 데이터 정보
		
		} else if (typeClss.equals("ST")) { // ST
					getCollectionDataInfo = colService.getCollectionDataInfoST(searchKeyWord); // 컬렉션 자료유형 ST 데이터 정보
		
		} else if (typeClss.equals("SC")) { // 시나리오,콘티
					getCollectionDataInfo = colService.getCollectionDataInfoSC(searchKeyWord); // 컬렉션 자료유형 SC 데이터 정보
		
		} else if (typeClss.equals("RE")) { // 음반
					getCollectionDataInfo = colService.getCollectionDataInfoRE(searchKeyWord); // 컬렉션 자료유형 RE 데이터 정보
		
		} else if (typeClss.equals("PO")) { // 포스터
					getCollectionDataInfo = colService.getCollectionDataInfoPO(searchKeyWord); // 컬렉션 자료유형 PO 데이터 정보
		
		} else if (typeClss.equals("NE")) { // 보도자료
					getCollectionDataInfo = colService.getCollectionDataInfoNE(searchKeyWord); // 컬렉션 자료유형 NE 데이터 정보
		
		} else if (typeClss.equals("MU")) { // 동영상
					getCollectionDataInfo = colService.getCollectionDataInfoMU(searchKeyWord); // 컬렉션 자료유형 MU 데이터 정보
		
		} else if (typeClss.equals("HA")) { // 전단
					getCollectionDataInfo = colService.getCollectionDataInfoHA(searchKeyWord); // 컬렉션 자료유형 HA 데이터 정보
		
		} else if (typeClss.equals("CE")) { // 심의서류
					getCollectionDataInfo = colService.getCollectionDataInfoCE(searchKeyWord); // 컬렉션 자료유형 CE 데이터 정보
		
		} else if (typeClss.equals("BO")) { // 책(도서)
					getCollectionDataInfo = colService.getCollectionDataInfoBO(searchKeyWord); // 컬렉션 자료유형 BO 데이터 정보
		
		} else if (typeClss.equals("AT")) { // 기사,평론
					getCollectionDataInfo = colService.getCollectionDataInfoAT(searchKeyWord); // 컬렉션 자료유형 AT 데이터 정보
		
		} else if (typeClss.equals("EQ")) { // 박물류 
					getCollectionDataInfo = colService.getCollectionDataInfoEQ(searchKeyWord); // 컬렉션 자료유형 AT 데이터 정보
		
		} else if (typeClss.equals("FI")) { // 자료유형 필름 
					getCollectionDataInfo = colService.getCollectionDataInfoFI(searchKeyWord); // 컬렉션 자료유형 AT 데이터 정보
		
		} else if (typeClss.equals("DC")) { // 자료유형 필름 
					getCollectionDataInfo = colService.getCollectionDataInfoDC(searchKeyWord); // 컬렉션 자료유형 AT 데이터 정보
		
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		//getDescription = kofacollectionListService.getDescription(colId);
		relationShipCollectionTitle = colService.getrelationShipCollectionTitle(dataId); // 연관 컬렉션 정보
		
		model.addAttribute("colId", colId);
		model.addAttribute("colName", colName);	
		model.addAttribute("typeClss", typeClss);
		model.addAttribute("colName", colName);
		model.addAttribute("dataId", dataId);
		model.addAttribute("dataNm", dataNm);
		model.addAttribute("getCollectionDataInfo", getCollectionDataInfo); // 해당 컬렉션 자료 데이터 정보;
		model.addAttribute("relationShipCollectionTitle",relationShipCollectionTitle); // 연관 컬렉션  정보
		
		return "/kofa/pop/itemDetailPop";
	}
	
	/**
	 * @writer [2021-09-29 주환 작성 ]
	 * @desc kofacollection 사용자단 파일 다운로드 메서드 
	 * @return 
	 * @throws Exception
	 * @test => required false 로 해당 파라미터 필수값을 false 를 통해 임시적으로 로직이 실행되는지 test
	 * @test url => http://localhost:8080/collectionlist/collectionFileDownload
	 */
	@RequestMapping(value = "/collectionFileDownload")
	public  void fileDownload(
			  @RequestParam(value ="document_nm", required = false) String document_nm
			, HttpSession session
			, HttpServletRequest req
			, HttpServletResponse res
			, ModelAndView mav) throws Throwable 
		{
		try {
			KofaCollectionDownloadFile fileDown = new KofaCollectionDownloadFile(); //파일다운로드 객체생성
			// local file download path => /home/kfupload/www/exhibitionManage/
			//fileDown.filDown(req, res, "파일경로입력" + "/" , "파일이름이력", "다운받았을때출력되는파일이름입력"); //파일다운로드 
			fileDown.filDown(req, res, "/home/kfupload/www/exhibitionManage/" , "3e953a72-e221-40f3-a175-871d1857bc30.PNG", "3e953a72-e221-40f3-a175-871d1857bc30.PNG"); //파일다운로드 

			
			 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
}
