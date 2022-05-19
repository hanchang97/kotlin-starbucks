package com.hanchang97.starbucks.model.whatsnew


import com.google.gson.annotations.SerializedName

data class Vo(
    @SerializedName("active_QUATER")
    val activeQUATER: String? = "",
    @SerializedName("active_YEAR")
    val activeYEAR: String? = "",
    @SerializedName("after_seq")
    val afterSeq: Int? = 0,
    @SerializedName("app_contn_btn_img_name")
    val appContnBtnImgName: Any? = Any(),
    @SerializedName("app_contn_btn_link_url")
    val appContnBtnLinkUrl: Any? = Any(),
    @SerializedName("app_contn_cntnt")
    val appContnCntnt: Any? = Any(),
    @SerializedName("app_contn_cntnt_img_name")
    val appContnCntntImgName: Any? = Any(),
    @SerializedName("app_thnl_img_name")
    val appThnlImgName: Any? = Any(),
    @SerializedName("app_yn")
    val appYn: String? = "",
    @SerializedName("appyn")
    val appyn: String? = "",
    @SerializedName("banner_type")
    val bannerType: Any? = Any(),
    @SerializedName("befor_seq")
    val beforSeq: Int? = 0,
    @SerializedName("cate")
    val cate: String? = "",
    @SerializedName("cate_cd")
    val cateCd: String? = "",
    @SerializedName("cate_nm")
    val cateNm: String? = "",
    @SerializedName("content")
    val content: String? = "",
    @SerializedName("contn_cntnt_xpsr_dvsn_code")
    val contnCntntXpsrDvsnCode: Any? = Any(),
    @SerializedName("contn_ctn_cntnt")
    val contnCtnCntnt: Any? = Any(),
    @SerializedName("csm_edt")
    val csmEdt: Any? = Any(),
    @SerializedName("csm_sdt")
    val csmSdt: Any? = Any(),
    @SerializedName("decode")
    val decode: String? = "",
    @SerializedName("del_yn")
    val delYn: String? = "",
    @SerializedName("departments")
    val departments: String? = "",
    @SerializedName("endDate")
    val endDate: String? = "",
    @SerializedName("end_dt")
    val endDt: Any? = Any(),
    @SerializedName("excel_Name")
    val excelName: String? = "",
    @SerializedName("excel_yn")
    val excelYn: String? = "",
    @SerializedName("fileName")
    val fileName: String? = "",
    @SerializedName("file_nm")
    val fileNm: String? = "",
    @SerializedName("file_nm1")
    val fileNm1: String? = "",
    @SerializedName("file_nm2")
    val fileNm2: String? = "",
    @SerializedName("file_nm3")
    val fileNm3: String? = "",
    @SerializedName("file_type")
    val fileType: String? = "",
    @SerializedName("firstIndex")
    val firstIndex: Int? = 0,
    @SerializedName("hit")
    val hit: Int? = 0,
    @SerializedName("img_nm")
    val imgNm: String? = "",
    @SerializedName("img_nm_tag")
    val imgNmTag: Any? = Any(),
    @SerializedName("lastIndex")
    val lastIndex: Int? = 0,
    @SerializedName("menu_cd")
    val menuCd: String? = "",
    @SerializedName("message")
    val message: Any? = Any(),
    @SerializedName("mod_dt")
    val modDt: String? = "",
    @SerializedName("mod_user")
    val modUser: String? = "",
    @SerializedName("news_dt")
    val newsDt: String? = "",
    @SerializedName("next_regdate")
    val nextRegdate: String? = "",
    @SerializedName("next_seq")
    val nextSeq: Int? = 0,
    @SerializedName("next_title")
    val nextTitle: String? = "",
    @SerializedName("order_num")
    val orderNum: Int? = 0,
    @SerializedName("pageIndex")
    val pageIndex: Int? = 0,
    @SerializedName("pageSize")
    val pageSize: Int? = 0,
    @SerializedName("page_status")
    val pageStatus: String? = "",
    @SerializedName("pageType")
    val pageType: String? = "",
    @SerializedName("pageUnit")
    val pageUnit: Int? = 0,
    @SerializedName("period_type")
    val periodType: Any? = Any(),
    @SerializedName("prev_regdate")
    val prevRegdate: String? = "",
    @SerializedName("prev_seq")
    val prevSeq: Int? = 0,
    @SerializedName("prev_title")
    val prevTitle: String? = "",
    @SerializedName("product_cd")
    val productCd: String? = "",
    @SerializedName("recordCountPerPage")
    val recordCountPerPage: Int? = 0,
    @SerializedName("reg_dt")
    val regDt: String? = "",
    @SerializedName("reg_user")
    val regUser: String? = "",
    @SerializedName("resultBoolean")
    val resultBoolean: Boolean? = false,
    @SerializedName("resultString")
    val resultString: Any? = Any(),
    @SerializedName("rnum")
    val rnum: Int? = 0,
    @SerializedName("row")
    val row: String? = "",
    @SerializedName("sSeq")
    val sSeq: String? = "",
    @SerializedName("san_content")
    val sanContent: String? = "",
    @SerializedName("san_index")
    val sanIndex: Int? = 0,
    @SerializedName("san_openyn")
    val sanOpenyn: String? = "",
    @SerializedName("san_regdate")
    val sanRegdate: String? = "",
    @SerializedName("san_title")
    val sanTitle: String? = "",
    @SerializedName("search")
    val search: Any? = Any(),
    @SerializedName("searchCondition")
    val searchCondition: String? = "",
    @SerializedName("searchKey")
    val searchKey: String? = "",
    @SerializedName("searchKeyword")
    val searchKeyword: String? = "",
    @SerializedName("search_word")
    val searchWord: Any? = Any(),
    @SerializedName("search_word_type")
    val searchWordType: Any? = Any(),
    @SerializedName("seq")
    val seq: Int? = 0,
    @SerializedName("startDate")
    val startDate: String? = "",
    @SerializedName("start_dt")
    val startDt: Any? = Any(),
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("statusPage")
    val statusPage: String? = "",
    @SerializedName("store_code")
    val storeCode: Any? = Any(),
    @SerializedName("sub_title_name")
    val subTitleName: Any? = Any(),
    @SerializedName("tag_seq")
    val tagSeq: Int? = 0,
    @SerializedName("tag_txt")
    val tagTxt: String? = "",
    @SerializedName("thum_img_yn")
    val thumImgYn: String? = "",
    @SerializedName("thumbnail_nm")
    val thumbnailNm: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("totalCnt")
    val totalCnt: Int? = 0,
    @SerializedName("view_ty")
    val viewTy: Int? = 0,
    @SerializedName("view_yn")
    val viewYn: String? = "",
    @SerializedName("web_contn_btn_img_name")
    val webContnBtnImgName: Any? = Any(),
    @SerializedName("web_contn_btn_link_url")
    val webContnBtnLinkUrl: Any? = Any(),
    @SerializedName("web_contn_cntnt_img_name")
    val webContnCntntImgName: Any? = Any(),
    @SerializedName("web_contn_link_nwndw_yn")
    val webContnLinkNwndwYn: Any? = Any(),
    @SerializedName("web_yn")
    val webYn: String? = "",
    @SerializedName("webxpsrseqc")
    val webxpsrseqc: String? = "",
    @SerializedName("wmonth")
    val wmonth: String? = "",
    @SerializedName("wyear")
    val wyear: String? = ""
)