package egovframework.ag.homepage.kofacollection.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.ag.common.annotation.KMDBMapper;
import egovframework.ag.homepage.kofacollection.vo.KmdbCollectionsVO;

@KMDBMapper
public interface KfCollectionDao {

	List<KmdbCollectionsVO> selectColName(HashMap<String, Object> searchKeyWord) throws Exception;

	String selectSearchColName() throws Exception;

	List<KmdbCollectionsVO> selectNewName(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> selectBestName(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> selectDetailAlbumUpdate(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> selectDetailAlbumAbc(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> selectDetailListUpdate(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> selectDetailListAbc(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> selectDetailView1HashMap(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> selectDetailView(HashMap<String, Object> searchKeyWord) throws Exception;
	
	List<KmdbCollectionsVO> selectDetailDataList(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public int selectDetailDataListCount(String colId) throws Exception;

	List<KmdbCollectionsVO> selectKofaGroupDesc(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> collectionName(HashMap<String, Object> searchKeyWord) throws Exception;

	/**
	 * 해당 게시물의 colId 로 정렬 기준 (sort ) 조회
	 * 
	 * @param nation (colId)
	 * @return
	 * @throws Exception
	 */
	public List<KmdbCollectionsVO> selectSorts(HashMap<String, Object> searchKeyWord) throws Exception;

	/*
	 * 관련 자료 data 페이징을 위한 count
	 */
	/**
	 * paging List
	 * 
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	public int selectCollectionAjaxDataCount(HashMap<String, Object> searchMap) throws Exception;

	public List<Map<String, Object>> selectCollectionAjaxDataList(HashMap<String, Object> searchMap) throws Exception;

	/**
	 * @desc 관련 seq 에 대한 data 자료 갯수 select
	 * @param searchMap
	 * @return
	 */
	public int totalDataCount(HashMap<String, Object> searchKeyWord) throws Exception;

	/**
	 * @desc paging data list
	 * @param searchMap
	 * @return
	 */
	public List<KmdbCollectionsVO> getPagingData(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public List<HashMap<String , Object>>getPagingDataAjax(HashMap<String, Object> searchMap) throws Exception;

	List<KmdbCollectionsVO> getDataByIdxEtc(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> getDataByIdx(HashMap<String, Object> searchKeyWord) throws Exception;

	public int defaultListCount(String upperColId) throws Exception;

	public List<KmdbCollectionsVO> selectDataClass(HashMap<String, Object> searchKeyWord) throws Exception;

	public KmdbCollectionsVO getCollectionDataInfoVI(HashMap<String, Object> searchKeyWord) throws Exception;

	public KmdbCollectionsVO getCollectionDataInfoTH(HashMap<String, Object> searchKeyWord) throws Exception;

	public KmdbCollectionsVO getCollectionDataInfoVO(HashMap<String, Object> searchKeyWord) throws Exception;

	public KmdbCollectionsVO getCollectionDataInfoSF(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoST(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoSC(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoRE(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoPO(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoNE(HashMap<String, Object> searchKeyWord) throws Exception;

	public KmdbCollectionsVO getCollectionDataInfoMU(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoHA(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoCE(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoBO(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoAT(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoEQ(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoFI(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO getCollectionDataInfoDC(HashMap<String, Object> searchKeyWord) throws Exception;

	public List<KmdbCollectionsVO> getrelationShipCollectionTitle(String dataId) throws Exception;

	public int getDataByIdxEtcCount(String upperColId) throws Exception;

	public int getDataByIdxCount(HashMap<String, Object> searchKeyWord) throws Exception;

	List<KmdbCollectionsVO> getDataByIdxAll(HashMap<String, Object> searchKeyWord) throws Exception;

	//List<KmdbCollectionsVO> getIdxResult(HashMap<String, Object> searchKeyWord) throws Exception;

	public KmdbCollectionsVO sortCheckBox(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO sortCheckBox2(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO sortCheckBox3(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO sortCheckBox4(HashMap<String, Object> searchKeyWord) throws Exception;
	
	public KmdbCollectionsVO sortCheckBox5(HashMap<String, Object> searchKeyWord) throws Exception;

}
