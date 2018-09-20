package com.downeyjr.util;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
	 // The number of current page size
    private int currentPage;

    // The number of records in one page
    private int pageSize;

    // The total number of records in DB
    private int total;

   

	// The total number of page
    private int pageCount;

    // The number where we begin to get record
    private int startRecord;

    // Whether it has previous page
    private boolean hasPreviousPage;

    // Whether it has next page
    private boolean hasNextPage;

    // Whether it has only one page
    private boolean onlyOnePage;

    // The records of page designed
    private List<T> pageRecords;
    
    private int[] numbers;//չʾҳ������

    public int getCurrentPage() {
        return currentPage;
    }
    
    /**
     * ���췽����ֻ�����ҳ.
     */
    public Pager() {
    	this(1, 0, 2, new ArrayList());
    }
    
    /**
	 * ���췽����ֻ�����ҳ.
	 */
	public Pager(int currentPage,int pageSize) {
		this(currentPage, 0, pageSize, new ArrayList());
	}
	
	/**
	 * Ĭ�Ϲ��췽��.
	 * 
	 * @param start
	 *            ��ҳ���������ݿ��е���ʼλ��
	 * @param totalSize
	 *            ���ݿ����ܼ�¼����
	 * @param pageSize
	 *            ��ҳ����
	 * @param data
	 *            ��ҳ����������
	 */
	public Pager(int currentPage, int totalSize, int pageSize, List data) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.total = totalSize;
		this.pageRecords = data;
	}

    /**
     * make sure the page is in the range of the total pages
     * 
     * @param currentPage
     *            current page
     */
    public void setCurrentPage(int currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
            return;
        }
        /*if (currentPage > getPageCount()) {
            this.currentPage = getPageCount();
            return;
        }*/
        this.currentPage = currentPage;
    }

    /**
     * get page size
     * 
     * @return page size number
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * set page size
     * 
     * @param pageSize
     *            page size number
     */
    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * get total records
     * 
     * @return total record's number
     */
    public int getTotal() {
        return total;
    }

    /**
     * set total records
     * 
     * @param totalRecords
     *            total record number
     */
    public void setTotal(int totalRecords) {
        this.total = totalRecords;
    }
   
    
    public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
    
    /**
     * Get the total count of the page
     * 
     * @return count number
     */
    public int getPageCount() {
        // If there is no data in database.
        if (total == 0) {
            pageCount = 1;
            return pageCount;
        }
        boolean isZero = total % pageSize == 0;
        pageCount = total / pageSize;
        pageCount = isZero ? pageCount : pageCount + 1;
        setNumbers(pageCount);//��ȡչʾҳ������
        return pageCount;
    }
    
    public int[] getNumbers() {
		return numbers;
	}
	
	/**
	 * ������ʾҳ������
	 * @param totalPageCount
	 */
	public void setNumbers(int totalPageCount) {
		if(totalPageCount>0){
			int[] numbers = new int[totalPageCount>3?3:totalPageCount];//ҳ��Ҫ��ʾ��ҳ������
			int k =0;
			for(int i = 0;i < totalPageCount;i++){
				//��֤��ǰҳΪ���ϵ��м�
				if((i>=currentPage- (numbers.length/2+1) || i >= totalPageCount-numbers.length) && k<numbers.length){
					numbers[k] = i+1;
					k++;
				}else if(k>=numbers.length){
					break;
				}
				
			}
			
			this.numbers = numbers;
		}
		
	}
	
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

    /**
     * First record of one page
     * 
     * @return start records
     */
    public int getStartRecord() {
        startRecord = ((currentPage - 1) * pageSize);
        return startRecord;
    }

    /**
     * Whether has previous page
     * 
     * @return if previous page's is exist,return true else not
     */
    public boolean isHasPreviousPage() {
        hasPreviousPage = (currentPage == 1) ? false : true;
        return hasPreviousPage;
    }

    /**
     * Whether has next page
     * 
     * @return if next page's is exist,return true else not
     */
    public boolean isHasNextPage() {
        hasNextPage = (currentPage == getPageCount()) ? false : true;
        return hasNextPage;
    }

    /**
     * Whether is only one page
     * 
     * @return if only one page,return true else not
     */
    public boolean isOnlyOnePage() {
        onlyOnePage = ((getPageCount() == 1) ? true : false);
        return onlyOnePage;
    }

    
    /**
     * ��ѯ�������еļ�¼
     * @return the pageRecords
     */
    public List<T> getPageRecords() {
        return pageRecords;
    }

	public void setPageRecords(List<T> pageRecords) {
		this.pageRecords = pageRecords;
	}
}
