package kr.niee.mdt.common;

public class PagingVO {
	private int currentPage;
	private int totalCount;
	private int totalPage;
	private int blockCount;
	private int blockPage;
	private int startCount;
	private int endCount;
	private int startPage;
	private int endPage;

	public PagingVO(int currentPage,int totalCount,int blockCount,int blockPage){
			this.currentPage=currentPage;
			this.totalCount=totalCount;
			this.blockCount=blockCount;
			this.blockPage=blockPage;
			
			totalPage=(int)Math.ceil((double)totalCount/blockCount);
			if(totalPage==0){
				totalPage=1;
			}
			
			if(currentPage>totalPage){
				currentPage=totalPage;
			}
			
			startCount=(currentPage-1)*blockCount;
			endCount=blockCount;
			
			startPage=(int)((currentPage-1)/blockPage)*blockPage+1;
			endPage=startPage+blockPage-1;
			
			if(endPage>totalPage){
				endPage=totalPage;
			}
			
		}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}
