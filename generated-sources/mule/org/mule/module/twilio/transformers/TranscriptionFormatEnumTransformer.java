
package org.mule.module.twilio.transformers;

import javax.annotation.Generated;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.module.twilio.TranscriptionFormat;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class TranscriptionFormatEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public TranscriptionFormatEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(TranscriptionFormat.class);
        setName("TranscriptionFormatEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        TranscriptionFormat result = null;
        result = Enum.valueOf(TranscriptionFormat.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
