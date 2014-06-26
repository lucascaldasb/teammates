package teammates.storage.entity;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import teammates.common.datatransfer.CommentSendingState;

import com.google.appengine.api.datastore.Text;

/**
 * An association class that represents the association 
 * Giver --> [comments about] --> FeedbackResponse.
 * Currently giver is restricted only to Instructors.
 * Comments are visible to the receiver of the FeedbackResponse
 * and anybody who can see the FeedbackResponse
 */
@PersistenceCapable
public class FeedbackResponseComment {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private transient Long feedbackResponseCommentId = null;
    
    /** The foreign key to locate the Course object. */
    @Persistent
    private String courseId;
    
    /** The foreign key to locate the FeedbackSession object. */
    @Persistent
    private String feedbackSessionName;
    
    /** The foreign key to locate the FeedbackQuestion object. */
    @Persistent
    private String feedbackQuestionId;
    
    
    /** The course-specific email used by the giver of the comment. */
    @Persistent
    private String giverEmail;
    
    /** The foreign key to locate the FeedbackResponse object commented on. */
    @Persistent
    private String feedbackResponseId;
    
    /** Is this comment pending to be sent to recipient (through email) or sending or sent */
    @Persistent
    private CommentSendingState sendingState;
    
    /** The creation time of this comment. */
    @Persistent
    private Date createdAt;
    
    /** The comment from giver about the feedback response */
    @Persistent
    @Extension(vendorName = "datanucleus", key = "gae.unindexed", value = "true")
    private Text commentText;
    
    public FeedbackResponseComment(String courseId, String feedbackSessionName,
            String feedbackQuestionId, String giverEmail, String feedbackResponseId, 
            CommentSendingState sendingState, Date createdAt, Text commentText) {
        this.feedbackResponseCommentId = null; // Auto generated by GAE
        this.courseId = courseId;
        this.feedbackSessionName = feedbackSessionName;
        this.feedbackQuestionId = feedbackQuestionId;
        this.giverEmail = giverEmail;
        this.feedbackResponseId = feedbackResponseId;
        this.sendingState = sendingState;
        this.createdAt = createdAt;
        this.commentText = commentText;
    }

    /** Use only if the comment already persisted 
     * in the datastore and id generated by GAE
     * @return the feedbackResponseCommentId
     */
    public Long getFeedbackResponseCommentId() {
        return feedbackResponseCommentId;
    }

    /* Auto generated by GAE. Don't set this.
    public void setFeedbackResponseCommentId(Long feedbackResponseCommentId) {
        this.feedbackResponseCommentId = feedbackResponseCommentId;
    }*/

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getFeedbackSessionName() {
        return feedbackSessionName;
    }

    public void setFeedbackSessionName(String feedbackSessionName) {
        this.feedbackSessionName = feedbackSessionName;
    }
    
    public String getFeedbackQuestionId() {
        return feedbackQuestionId;
    }

    public void setFeedbackQuestionId(String feedbackQuestionId) {
        this.feedbackQuestionId = feedbackQuestionId;
    }

    public String getGiverEmail() {
        return giverEmail;
    }

    /**
     * @param giverEmail the giverEmail to set.
     * This is the email used by the user in the course,
     * not the one associated with the user's google account.
     */
    public void setGiverEmail(String giverEmail) {
        this.giverEmail = giverEmail;
    }

    public String getFeedbackResponseId() {
        return feedbackResponseId;
    }

    public void setFeedbackResponseId(String feedbackResponseId) {
        this.feedbackResponseId = feedbackResponseId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public CommentSendingState getSendingState() {
        return sendingState;
    }
    
    public void setSendingState(CommentSendingState sendingState){
        this.sendingState = sendingState;
    }
    
    public Text getCommentText() {
        return commentText;
    }

    public void setCommentText(Text commentText) {
        this.commentText = commentText;
    }
}
