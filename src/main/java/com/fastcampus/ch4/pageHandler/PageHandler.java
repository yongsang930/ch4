package com.fastcampus.ch4.pageHandler;

public class PageHandler {
    //    private int page; // 현재 페이지
//    private int pageSize; // 한 페이지당 게시물 갯수
//    private String option;
//    private String keyword;
    private SearchCondition sc;

    private int totalCnt; // 게시물의 총 갯수
    private int naviSize = 10; // 노출할 페이지 갯수
    private int totalPage; // 전체 페이지의 갯수
    private int beginPage; // 화면에 보여줄 첫 페이지
    private int endPage; // 화면에 보여줄 마지막 페이지
    private boolean showPrev = false; // 이전을 보여줄지의 여부. beginPage==1이 아니면 showPrev는 false
    private boolean showNext = false; // 이후를 보여줄지의 여부. endPage==totalPage이면, showNext는 false

    public final int NAV_SIZE = 10; // page navigation size

    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }

    // totalCnt: 100, page: 8, pageSize: 10, naviSize: 10
    void doPaging(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt; // 100

        // totalPage: 10
        totalPage = (int) Math.ceil(totalCnt / (double) sc.getPageSize());

        // beginPage = (10-1)/10 = 0
        // = 0 * 10 + 1
        // = 1
        beginPage = (sc.getPage() - 1) / naviSize * naviSize + 1;

        // endPage: 10
        endPage = Math.min(beginPage + naviSize - 1, totalPage);


        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    public int getNAV_SIZE() {
        return NAV_SIZE;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    void print() {
        System.out.println("page=" + sc.getPage());
        System.out.print(showPrev ? "PREV " : "");

        for (int i = beginPage; i <= endPage; i++) {
            System.out.print(i + " ");
        }
        System.out.println(showNext ? " NEXT" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", totalCnt=" + totalCnt +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                ", NAV_SIZE=" + NAV_SIZE +
                '}';
    }
}
