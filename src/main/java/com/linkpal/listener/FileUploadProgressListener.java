package com.linkpal.listener;


import com.linkpal.model.Progress;
import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.http.HttpSession;

public class FileUploadProgressListener implements ProgressListener {

    private HttpSession session;

    public void setSession(HttpSession session){
        this.session = session;
        Progress status = new Progress();
        session.setAttribute("status", status);
    }
    @Override
    public void update(long bytesRead, long contentLength, int items) {
        Progress status = (Progress) session.getAttribute("status");
        status.setBytesRead(bytesRead);
        status.setContentLength(contentLength);
        status.setItems(items);
    }
}
