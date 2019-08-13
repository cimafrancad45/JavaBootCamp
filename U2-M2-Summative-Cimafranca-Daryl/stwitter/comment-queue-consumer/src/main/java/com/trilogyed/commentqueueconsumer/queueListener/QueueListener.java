package com.trilogyed.commentqueueconsumer.queueListener;

import com.trilogyed.commentqueueconsumer.CommentQueueConsumerApplication;
import com.trilogyed.commentqueueconsumer.model.Comment;
import com.trilogyed.commentqueueconsumer.util.feign.CommentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueListener {
    @Autowired
    CommentService service;

    @RabbitListener(queues = CommentQueueConsumerApplication.COMMENT_QUEUE)
    public void receiveQueue(Comment queueNote) {
        System.out.println("recieved");
        if (queueNote.getComment() == 0) {
            System.out.println("sent create");
            service.getComments(queueNote);
        } else {
            service.updateNotes(queueNote.getNoteId(), queueNote);
        }
        service.(queueNote.getNoteId());
        service.getAllNotes();
        service.getNotesByBookId(queueNote.getBookId());
    }

}