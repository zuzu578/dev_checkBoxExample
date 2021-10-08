package egovframework.ag.homepage.kofacollection.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.ag.homepage.kofacollection.vo.CollectionPagingVo;
import egovframework.ag.homepage.kofacollection.vo.KmdbCollectionsVO;

@Service
public class KfCollectionService {

	@Autowired
	private KfCollectionDao kDao;
	
	public List<KmdbCollectionsVO> selectColName(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectColName(searchKeyWord);
	}

	public String selectSearchColName() throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectSearchColName();
	}
	
	public List<KmdbCollectionsVO> selectNewName(HashMap<String, Object> searchKeyWord) throws Exception{
		// TODO Auto-generated method stub
		return kDao.selectNewName(searchKeyWord);
	}
	
	public List<KmdbCollectionsVO> selectBestName(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectBestName(searchKeyWord);
	}
	

	public List<KmdbCollectionsVO> selectDetailAlbumUpdate(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectDetailAlbumUpdate(searchKeyWord);
	}

	public List<KmdbCollectionsVO> selectDetailAlbumAbc(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectDetailAlbumAbc(searchKeyWord);
	}

	public List<KmdbCollectionsVO> selectDetailListUpdate(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectDetailListUpdate(searchKeyWord);
	}

	public List<KmdbCollectionsVO> selectDetailListAbc(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectDetailListAbc(searchKeyWord);
	}

	public List<KmdbCollectionsVO> selectDetailView(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectDetailView(searchKeyWord);
	}
	
	public List<KmdbCollectionsVO> selectDetailDataList(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectDetailDataList(searchKeyWord);
	}
	
	public int selectDetailDataListCount(String colId) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectDetailDataListCount(colId);
	}

	public List<KmdbCollectionsVO> selectKofaGroupDesc(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectKofaGroupDesc(searchKeyWord);
	}

	public List<KmdbCollectionsVO> collectionName(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.collectionName(searchKeyWord);
	}


	public List<KmdbCollectionsVO> selectSorts(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectSorts(searchKeyWord);
	}

	public CollectionPagingVo selectCollectionAjaxData(HashMap<String, Object> searchKeyWord) throws Exception {
		return null;
	
		
	}
	// paging 처리를 위한 data total count 
	public int totalDataCount(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.totalDataCount(searchKeyWord);
	}
	// paging data list 
	public List<KmdbCollectionsVO> getPagingData(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.getPagingData(searchKeyWord);
	}
	// detailList 분류체계 checkbox
	public List<HashMap<String , Object>>getPagingDataAjax(HashMap<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return kDao.getPagingDataAjax(searchMap);
	}
//
	// 기타 색인을 클릭할때 데이터를 가져옵니다. 
	public List<KmdbCollectionsVO> getDataByIdxEtc(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.getDataByIdxEtc(searchKeyWord);
	}
	// 색인으로 데이터를 가져옵니다. 
	public List<KmdbCollectionsVO> getDataByIdx(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.getDataByIdx(searchKeyWord);
	}

	public int defaultListCount(String upperColId) throws Exception {
		// TODO Auto-generated method stub
		return kDao.defaultListCount(upperColId);
	}

	public List<KmdbCollectionsVO> selectDataClass(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.selectDataClass(searchKeyWord);
	} 
	
	public KmdbCollectionsVO getCollectionDataInfoVI(HashMap<String, Object> searchKeyWord) throws Exception {	// 비디오
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoVI(searchKeyWord);
	}
	
	public KmdbCollectionsVO getCollectionDataInfoTH(HashMap<String, Object> searchKeyWord) throws Exception {	// 학위 , 논문
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoTH(searchKeyWord);
	}
	
	public KmdbCollectionsVO getCollectionDataInfoVO(HashMap<String, Object> searchKeyWord) throws Exception {	// 정기간행물
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoVO(searchKeyWord);
	}
	
	public KmdbCollectionsVO getCollectionDataInfoSF(HashMap<String, Object> searchKeyWord) throws Exception {	// 스틸필름
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoSF(searchKeyWord);
	}
	public KmdbCollectionsVO getCollectionDataInfoST(HashMap<String, Object> searchKeyWord) throws Exception {	// ST
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoSC(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoSC(HashMap<String, Object> searchKeyWord) throws Exception {	// 시나리오,콘티
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoST(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoRE(HashMap<String, Object> searchKeyWord) throws Exception {	// 음반
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoRE(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoPO(HashMap<String, Object> searchKeyWord) throws Exception {	// 포스터
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoPO(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoNE(HashMap<String, Object> searchKeyWord) throws Exception {	// 보도자료
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoNE(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoMU(HashMap<String, Object> searchKeyWord) throws Exception {	// 동영상
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoMU(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoHA(HashMap<String, Object> searchKeyWord) throws Exception {	// 전단
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoHA(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoCE(HashMap<String, Object> searchKeyWord) throws Exception {	// 심의서류
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoCE(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoBO(HashMap<String, Object> searchKeyWord) throws Exception {	// 책(도서)
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoBO(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoAT(HashMap<String, Object> searchKeyWord) throws Exception {	// 기사,평론
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoAT(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoEQ(HashMap<String, Object> searchKeyWord) throws Exception {	// 박물류
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoEQ(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoFI(HashMap<String, Object> searchKeyWord) throws Exception {	// 자료유형 필름 
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoFI(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoDC(HashMap<String, Object> searchKeyWord) throws Exception {	// 자료유형 필름 
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoDC(searchKeyWord);
	}

	public List<KmdbCollectionsVO> getrelationShipCollectionTitle(String dataId) throws Exception {
		// TODO Auto-generated method stub
		return kDao.getrelationShipCollectionTitle(dataId);

//	public List<KmdbCollectionsVO> getIdxResult(HashMap<String, Object> searchKeyWord) throws Exception {
//		// TODO Auto-generated method stub
//		return kDao.getIdxResult(searchKeyWord);
//	}

	}

	public int getDataByIdxEtcCount(String upperColId) throws Exception  {
		// TODO Auto-generated method stub
		return kDao.getDataByIdxEtcCount(upperColId);
	}

	public int getDataByIdxCount(HashMap<String, Object> searchKeyWord) throws Exception{
		// TODO Auto-generated method stub
		return kDao.getDataByIdxCount(searchKeyWord);
	}

	public List<KmdbCollectionsVO> getDataByIdxAll(HashMap<String, Object> searchKeyWord) throws Exception{
		// TODO Auto-generated method stub
		return kDao.getDataByIdxAll(searchKeyWord);
	}
	// 분류체계 
	public KmdbCollectionsVO sortCheckBox(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.sortCheckBox(searchKeyWord);
	}

	public KmdbCollectionsVO sortCheckBox2(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.sortCheckBox2(searchKeyWord);
	}

	public KmdbCollectionsVO sortCheckBox3(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.sortCheckBox3(searchKeyWord);
	}

	public KmdbCollectionsVO sortCheckBox4(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.sortCheckBox4(searchKeyWord);
	}

	public KmdbCollectionsVO sortCheckBox5(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.sortCheckBox5(searchKeyWord);
	}


}
