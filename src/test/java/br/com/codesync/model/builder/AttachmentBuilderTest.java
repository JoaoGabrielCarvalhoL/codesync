package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Attachment;
import br.com.codesync.model.entity.Task;
import br.com.codesync.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

class AttachmentBuilderTest {

    @Test
    @DisplayName("Should create an attachment with valid values")
    void shouldCreateAttachmentWithValidValues() {
        UUID id = UUID.randomUUID();
        Instant uploadAt = Instant.now();

        Task task = new Task();
        User uploadedBy = new User();

        Attachment attachment = AttachmentBuilder.builder()
                .id(id)
                .filename("document.pdf")
                .contentType("application/pdf")
                .fileSize(1024L)
                .path("/uploads/document.pdf")
                .task(task)
                .uploadAt(uploadAt)
                .uploadedBy(uploadedBy)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, attachment.getId()),
                () -> Assertions.assertEquals("document.pdf", attachment.getFilename()),
                () -> Assertions.assertEquals("application/pdf", attachment.getContentType()),
                () -> Assertions.assertEquals(1024L, attachment.getFileSize()),
                () -> Assertions.assertEquals("/uploads/document.pdf", attachment.getPath()),
                () -> Assertions.assertEquals(task, attachment.getTask()),
                () -> Assertions.assertEquals(uploadAt, attachment.getUploadAt()),
                () -> Assertions.assertEquals(uploadedBy, attachment.getUploadedBy())
        );
    }

    @Test
    @DisplayName("Should create an empty attachment when no values are provided")
    void shouldCreateEmptyAttachmentWhenNoValuesAreProvided() {
        Attachment attachment = AttachmentBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(attachment.getId()),
                () -> Assertions.assertNull(attachment.getFilename()),
                () -> Assertions.assertNull(attachment.getContentType()),
                () -> Assertions.assertNull(attachment.getFileSize()),
                () -> Assertions.assertNull(attachment.getPath()),
                () -> Assertions.assertNull(attachment.getTask()),
                () -> Assertions.assertNotNull(attachment.getUploadAt()),
                () -> Assertions.assertNull(attachment.getUploadedBy())
        );
    }
}