package com.aec.demo.dds;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rti.dds.domain.DomainParticipantAdapter;
import com.rti.dds.publication.DataWriter;
import com.rti.dds.publication.OfferedIncompatibleQosStatus;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.RequestedIncompatibleQosStatus;
import com.rti.dds.topic.InconsistentTopicStatus;
import com.rti.dds.topic.Topic;

public final class DomainListener extends DomainParticipantAdapter {

	private static final Logger LOG = LogManager.getLogger(DomainListener.class);

    @Override
    public void on_inconsistent_topic(
            Topic topic, InconsistentTopicStatus status) {

        LOG.info(
                "Found inconsistent topic. Expecting " +
                topic.get_name() +
                " of type " +
                topic.get_type_name());
    }


    @Override
    public void on_offered_incompatible_qos(
            DataWriter writer, OfferedIncompatibleQosStatus status) {

    	LOG.info(
                "Found incompatible reader for writer " +
                writer.get_topic().get_name() +
                "  QoS is " +
                status.last_policy_id);
    }


    @Override
    public void on_requested_incompatible_qos(
            DataReader reader, RequestedIncompatibleQosStatus status) {

    	LOG.info(
                "Found incompatible writer for reader " +
                reader.get_topicdescription().get_name() +
                "  QoS is " +
                status.last_policy_id);
    }

}