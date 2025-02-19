package com.di.jmeter.kafka.sampler;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.TableEditor;
import org.apache.jmeter.testbeans.gui.TypeEditor;

import com.di.jmeter.kafka.utils.VariableSettings;

public class KafkaTestElementBeanInfoSupport extends BeanInfoSupport{

	protected KafkaTestElementBeanInfoSupport(Class<? extends TestBean> beanClass) {
		super(beanClass);

		createPropertyGroup("Variable Name bound to Kafka Client", new String[] {"kafkaProducerClientVariableName"});

		createPropertyGroup("Message to Produce", new String[] { "kafkaTopic","partitionString","kafkaMessageKey","kafkaMessage","messageHeaders" });
		//createPropertyGroup("Kafka Message Headers (Optional)", new String[] {"messageHeaders"});

		PropertyDescriptor kafkaProducerClientVariableNamePropDesc =  property("kafkaProducerClientVariableName");
		kafkaProducerClientVariableNamePropDesc.setValue(NOT_UNDEFINED, Boolean.TRUE);
		kafkaProducerClientVariableNamePropDesc.setValue(DEFAULT, "KafkaProducerClient");
		kafkaProducerClientVariableNamePropDesc.setDisplayName("Variable Name of Kafka Producer Client declared in KafkaProducerConfig");
		kafkaProducerClientVariableNamePropDesc.setShortDescription("Variable Name of Kafka Producer Client");

		PropertyDescriptor propDesc = property("kafkaTopic");
		propDesc.setValue(NOT_UNDEFINED, Boolean.TRUE);
		propDesc.setValue(DEFAULT, "kafka_topic");
		propDesc.setDisplayName("Kafka Topic");
		
		propDesc = property("partitionString");
		propDesc.setValue(NOT_UNDEFINED, Boolean.TRUE);
		propDesc.setValue(DEFAULT, "");
		propDesc.setDisplayName("Partition String");
		propDesc.setShortDescription("Leave it blank/empty if not required");
		
		propDesc = property("kafkaMessageKey");
		propDesc.setValue(NOT_UNDEFINED, Boolean.TRUE);
		propDesc.setValue(DEFAULT, "Key");
		propDesc.setDisplayName("Kafka Message Key");
		propDesc.setShortDescription("Kafka Message Key (blank/empty for null key)");

		propDesc = property("kafkaMessage", TypeEditor.TextAreaEditor);
		propDesc.setValue(NOT_UNDEFINED, Boolean.TRUE);
		propDesc.setValue(DEFAULT, "{\"Message\": \"It's a Hello from DI Kafka Sampler!\"}");
		propDesc.setDisplayName("Kafka Message");
		
		PropertyDescriptor headerTable = property("messageHeaders", TypeEditor.TableEditor);
		headerTable.setValue(TableEditor.CLASSNAME, VariableSettings.class.getName());
		headerTable.setValue(TableEditor.HEADERS, new String[]{ "Key", "Value" } );
		headerTable.setValue(TableEditor.OBJECT_PROPERTIES, new String[]{ VariableSettings.KEY, VariableSettings.VALUE } );
		headerTable.setValue(DEFAULT, new ArrayList<>());
		headerTable.setValue(NOT_UNDEFINED, Boolean.TRUE);
		headerTable.setDisplayName("Message Headers (Optional)");
		
		
	}

}
