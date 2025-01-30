package com.apr.students.api;

import com.apr.students.model.Notice;
import com.apr.students.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notices")
public class NoticeResource {

    @Autowired
    private NoticeService noticeService;

    @PostMapping
    public Notice addNotice(@RequestBody Notice notice) {
        return noticeService.addNotice(notice);
    }

    @GetMapping
    public List<Notice> getNotices() {
        return noticeService.getNotices();
    }

    @GetMapping(value = "/{noticeId}")
    public Notice getNotice(@PathVariable("noticeId") int noticeId) {
        return noticeService.getNotice(noticeId);
    }

    @PutMapping(value = "/{noticeId}")
    public Notice updateNotice(@PathVariable("noticeId") int noticeId, @RequestBody Notice notice) {
        return noticeService.updateNotice(noticeId, notice);
    }

    @DeleteMapping(value = "/{noticeId}")
    public void deleteNotice(@PathVariable("noticeId") int noticeId) {
        noticeService.deleteNotice(noticeId);
    }
}
