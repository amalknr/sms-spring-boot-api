package com.apr.students.service;

import com.apr.students.dao.NoticeDao;
import com.apr.students.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    public Notice addNotice(Notice notice) {
        return noticeDao.save(notice);
    }

    public List<Notice> getNotices() {
        return noticeDao.findAll();
    }

    public Notice getNotice(int noticeId) {
        return noticeDao.findById(noticeId).orElse(null);
    }

    public Notice updateNotice(int noticeId, Notice notice) {
        notice.setNoticeId(noticeId);
        return noticeDao.save(notice);
    }

    public void deleteNotice(int noticeId) {
        noticeDao.deleteById(noticeId);
    }
}
