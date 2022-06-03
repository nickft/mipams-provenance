package org.mipams.fake_media.entities.requests;

import java.util.ArrayList;
import java.util.List;

import org.mipams.jumbf.core.entities.JumbfBox;
import org.mipams.fake_media.entities.ClaimGenerator;
import org.mipams.fake_media.entities.ProvenanceSigner;
import org.mipams.fake_media.entities.assertions.Assertion;
import org.mipams.fake_media.entities.assertions.RedactableAssertion;

public class ProducerRequestBuilder {
    private ProducerRequest producerRequest;

    public ProducerRequestBuilder(String assetUrl) {
        reset();
        producerRequest.setAssetUrl(assetUrl);
    }

    public void reset() {
        this.producerRequest = new ProducerRequest();
    }

    public void setSigner(ProvenanceSigner signer) {
        this.producerRequest.setSigner(signer);
    }

    public void setClaimGenerator(ClaimGenerator claimGenerator) {
        this.producerRequest.setClaimGenerator(claimGenerator);
    }

    public void setAssertionList(List<Assertion> assertionList) {
        this.producerRequest.setAssertionList(new ArrayList<>(assertionList));
    }

    public void setRedactedAssertionList(List<RedactableAssertion> redactedAssertionList) {
        this.producerRequest.setRedactedAssertionList(new ArrayList<>(redactedAssertionList));
    }

    public void setCredentialStore(JumbfBox credentialJumbfBox) {
        this.producerRequest.setCredentialsStoreJumbfBox(credentialJumbfBox);
    }

    public ProducerRequest getResult() {
        return this.producerRequest;
    }

}
