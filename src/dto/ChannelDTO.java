package dto;

public class ChannelDTO {
    private long channel_id;
    private String channel_name;
    private long class_id;

    public ChannelDTO(long channel_id, String channel_name, long class_id) {
        this.channel_id = channel_id;
        this.channel_name = channel_name;
        this.class_id = class_id;
    }

    public long getChannel_id() {
        return channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public long getClass_id() {
        return class_id;
    }
}