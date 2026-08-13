package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Attachment;
import br.com.codesync.model.entity.Task;
import br.com.codesync.model.entity.User;

import java.time.Instant;
import java.util.UUID;

public class AttachmentBuilder {

    private Attachment attachment;

    private AttachmentBuilder() {
        this.attachment = new Attachment();
    }

    public static AttachmentBuilder builder() {
        return new AttachmentBuilder();
    }

    public AttachmentBuilder id(UUID id) {
        this.attachment.setId(id);
        return this;
    }

    public AttachmentBuilder filename(String filename) {
        this.attachment.setFilename(filename);
        return this;
    }

    public AttachmentBuilder contentType(String contentType) {
        this.attachment.setContentType(contentType);
        return this;
    }

    public AttachmentBuilder fileSize(Long fileSize) {
        this.attachment.setFileSize(fileSize);
        return this;
    }

    public AttachmentBuilder path(String path) {
        this.attachment.setPath(path);
        return this;
    }

    public AttachmentBuilder task(Task task) {
        this.attachment.setTask(task);
        return this;
    }

    public AttachmentBuilder uploadAt(Instant uploadAt) {
        this.attachment.setUploadAt(uploadAt);
        return this;
    }

    public AttachmentBuilder uploadedBy(User uploadedBy) {
        this.attachment.setUploadedBy(uploadedBy);
        return this;
    }

    public Attachment build() {
        Attachment result = this.attachment;
        this.attachment = new Attachment();
        return result;
    }
}
