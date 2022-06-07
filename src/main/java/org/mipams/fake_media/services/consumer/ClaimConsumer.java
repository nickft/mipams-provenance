package org.mipams.fake_media.services.consumer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper;

import org.mipams.jumbf.core.entities.CborBox;
import org.mipams.jumbf.core.entities.JumbfBox;
import org.mipams.jumbf.core.util.MipamsException;
import org.mipams.fake_media.entities.Claim;
import org.mipams.fake_media.entities.ProvenanceErrorMessages;
import org.springframework.stereotype.Service;

@Service
public class ClaimConsumer {
    public Claim desirializeClaimJumbfBox(JumbfBox claimJumbfBox) throws MipamsException {

        CborBox claimCborBox = (CborBox) claimJumbfBox.getContentBoxList().get(0);

        String cborFilePath = claimCborBox.getFileUrl();

        ObjectMapper mapper = new CBORMapper();
        try {
            return mapper.readValue(new File(cborFilePath), Claim.class);
        } catch (IOException e) {
            throw new MipamsException(ProvenanceErrorMessages.CBOR_DESERIALIZE_ERROR, e);
        }
    }
}
