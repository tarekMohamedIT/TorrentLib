package core.trackers;

import interfaces.ITracker;

public abstract class TrackerLink implements ITracker {
    String url;
    String infoHash;
    String peerID;
    int port;
    String uploaded;
    String downloaded;
    String left;
    boolean isCompact;

    public TrackerLink(String url, String infoHash, String peerID, int port, String uploaded, String downloaded, String left, boolean isCompact) {
        this.url = url;
        this.infoHash = infoHash;
        this.peerID = peerID;
        this.port = port;
        this.uploaded = uploaded;
        this.downloaded = downloaded;
        this.left = left;
        this.isCompact = isCompact;
    }



    @Override
    public String assembleTrackerLink() {
        return null;
    }
}
