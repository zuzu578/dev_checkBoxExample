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
	// paging ????????? ?????? data total count 
	public int totalDataCount(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.totalDataCount(searchKeyWord);
	}
	// paging data list 
	public List<KmdbCollectionsVO> getPagingData(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.getPagingData(searchKeyWord);
	}
	// detailList ???????????? checkbox
	public List<HashMap<String , Object>>getPagingDataAjax(HashMap<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return kDao.getPagingDataAjax(searchMap);
	}
//
	// ?????? ????????? ???????????? ???????????? ???????????????. 
	public List<KmdbCollectionsVO> getDataByIdxEtc(HashMap<String, Object> searchKeyWord) throws Exception {
		// TODO Auto-generated method stub
		return kDao.getDataByIdxEtc(searchKeyWord);
	}
	// ???????????? ???????????? ???????????????. 
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
	
	public KmdbCollectionsVO getCollectionDataInfoVI(HashMap<String, Object> searchKeyWord) throws Exception {	// ?????????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoVI(searchKeyWord);
	}
	
	public KmdbCollectionsVO getCollectionDataInfoTH(HashMap<String, Object> searchKeyWord) throws Exception {	// ?????? , ??????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoTH(searchKeyWord);
	}
	
	public KmdbCollectionsVO getCollectionDataInfoVO(HashMap<String, Object> searchKeyWord) throws Exception {	// ???????????????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoVO(searchKeyWord);
	}
	
	public KmdbCollectionsVO getCollectionDataInfoSF(HashMap<String, Object> searchKeyWord) throws Exception {	// ????????????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoSF(searchKeyWord);
	}
	public KmdbCollectionsVO getCollectionDataInfoST(HashMap<String, Object> searchKeyWord) throws Exception {	// ST
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoSC(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoSC(HashMap<String, Object> searchKeyWord) throws Exception {	// ????????????,??????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoST(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoRE(HashMap<String, Object> searchKeyWord) throws Exception {	// ??????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoRE(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoPO(HashMap<String, Object> searchKeyWord) throws Exception {	// ?????????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoPO(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoNE(HashMap<String, Object> searchKeyWord) throws Exception {	// ????????????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoNE(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoMU(HashMap<String, Object> searchKeyWord) throws Exception {	// ?????????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoMU(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoHA(HashMap<String, Object> searchKeyWord) throws Exception {	// ??????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoHA(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoCE(HashMap<String, Object> searchKeyWord) throws Exception {	// ????????????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoCE(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoBO(HashMap<String, Object> searchKeyWord) throws Exception {	// ???(??????)
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoBO(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoAT(HashMap<String, Object> searchKeyWord) throws Exception {	// ??????,??????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoAT(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoEQ(HashMap<String, Object> searchKeyWord) throws Exception {	// ?????????
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoEQ(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoFI(HashMap<String, Object> searchKeyWord) throws Exception {	// ???????????? ?????? 
		// TODO Auto-generated method stub
		return kDao.getCollectionDataInfoFI(searchKeyWord);
	}

	public KmdbCollectionsVO getCollectionDataInfoDC(HashMap<String, Object> searchKeyWord) throws Exception {	// ???????????? ?????? 
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
	// ???????????? 
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
