package org.xms.g.maps.model;

/**
 * xms Immutable item used in the stroke pattern for a Polyline or the outline of a Polygon or Circle.<br/>
 * Combination of com.huawei.hms.maps.model.PatternItem and com.google.android.gms.maps.model.PatternItem.<br/>
 * com.huawei.hms.maps.model.PatternItem: An immutable class that describes the stroke pattern of a polyline or the outline of a polygon or circle.<br/>
 * com.google.android.gms.maps.model.PatternItem: Immutable item used in the stroke pattern for a Polyline or the outline of a Polygon or Circle.<br/>
 */
public class PatternItem extends org.xms.g.utils.XObject implements android.os.Parcelable {
    /**
     * android.os.Parcelable.Creator.CREATOR a public CREATOR field that generates instances of your Parcelable class from a Parcel.<br/>
     * <p>
     * com.google.android.gms.maps.model.PatternItem.CREATOR: <a href="https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem">https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem</a><br/>
     */
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {
        
        public org.xms.g.maps.model.PatternItem createFromParcel(android.os.Parcel param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                com.huawei.hms.maps.model.PatternItem hReturn = com.huawei.hms.maps.model.PatternItem.CREATOR.createFromParcel(param0);
                return new org.xms.g.maps.model.PatternItem(new org.xms.g.utils.XBox(null, hReturn));
            } else {
                com.google.android.gms.maps.model.PatternItem gReturn = com.google.android.gms.maps.model.PatternItem.CREATOR.createFromParcel(param0);
                return new org.xms.g.maps.model.PatternItem(new org.xms.g.utils.XBox(gReturn, null));
            }
        }
        
        public org.xms.g.maps.model.PatternItem[] newArray(int param0) {
            return new org.xms.g.maps.model.PatternItem[param0];
        }
    };
    private boolean wrapper = true;
    
    /**
     * org.xms.g.maps.model.PatternItem.PatternItem(org.xms.g.utils.XBox) Immutable item used in the stroke pattern for a Polyline or the outline of a Polygon or Circle.<br/>
     * Support running environments including both HMS and GMS which are chosen by users.<br/>
     * Below are the references of HMS apis and GMS apis respectively:<br/>
     * com.huawei.hms.maps.model.PatternItem.PatternItem(): <a href="https://developer.huawei.com/consumer/en/doc/HMSCore-References-V5/patternitem-0000001050152951-V5">https://developer.huawei.com/consumer/en/doc/HMSCore-References-V5/patternitem-0000001050152951-V5</a><br/>
     * com.google.android.gms.maps.model.PatternItem.PatternItem(): <a href="https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem">https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem</a><br/>
     *
     * @param param0 the param should instanceof utils XBox
     */
    public PatternItem(org.xms.g.utils.XBox param0) {
        super(param0);
        wrapper = true;
    }
    
    /**
     * org.xms.g.maps.model.PatternItem.PatternItem(int,float) Immutable item used in the stroke pattern for a Polyline or the outline of a Polygon or Circle.<br/>
     * Support running environments including both HMS and GMS which are chosen by users.<br/>
     * Below are the references of HMS apis and GMS apis respectively:<br/>
     * com.huawei.hms.maps.model.PatternItem.PatternItem(int,float): <a href="https://developer.huawei.com/consumer/en/doc/HMSCore-References-V5/patternitem-0000001050152951-V5">https://developer.huawei.com/consumer/en/doc/HMSCore-References-V5/patternitem-0000001050152951-V5</a><br/>
     * com.google.android.gms.maps.model.PatternItem.PatternItem(int,float): <a href="https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem">https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem</a><br/>
     *
     * @param param0 the param should instanceof int
     * @param param1 the param should instanceof float
     */
    public PatternItem(int param0, float param1) {
        super(((org.xms.g.utils.XBox) null));
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl(param0, param1));
        } else {
            this.setGInstance(new GImpl(param0, param1));
        }
        wrapper = false;
    }
    
    /**
     * org.xms.g.maps.model.PatternItem.equals(java.lang.Object) equals.<br/>
     * Support running environments including both HMS and GMS which are chosen by users.<br/>
     * Below are the references of HMS apis and GMS apis respectively:<br/>
     * com.huawei.hms.maps.model.PatternItem.equals(java.lang.Object): <a href="https://developer.huawei.com/consumer/en/doc/development/HMS-References/hms-map-patternitem#equals(Object)">https://developer.huawei.com/consumer/en/doc/development/HMS-References/hms-map-patternitem#equals(Object)</a><br/>
     * com.google.android.gms.maps.model.PatternItem.equals(java.lang.Object): <a href="https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem#public-boolean-equals-object-o">https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem#public-boolean-equals-object-o</a><br/>
     *
     * @param param0 the param should instanceof java lang Object
     * @return the return object is boolean
     */
    public boolean equals(java.lang.Object param0) {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.maps.model.PatternItem) this.getHInstance()).equals(param0)");
                return ((com.huawei.hms.maps.model.PatternItem) this.getHInstance()).equals(param0);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.maps.model.PatternItem) this.getGInstance()).equals(param0)");
                return ((com.google.android.gms.maps.model.PatternItem) this.getGInstance()).equals(param0);
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((HImpl) ((com.huawei.hms.maps.model.PatternItem) this.getHInstance())).equalsCallSuper(param0)");
                return ((HImpl) ((com.huawei.hms.maps.model.PatternItem) this.getHInstance())).equalsCallSuper(param0);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((GImpl) ((com.google.android.gms.maps.model.PatternItem) this.getGInstance())).equalsCallSuper(param0)");
                return ((GImpl) ((com.google.android.gms.maps.model.PatternItem) this.getGInstance())).equalsCallSuper(param0);
            }
        }
    }
    
    /**
     * org.xms.g.maps.model.PatternItem.hashCode() hash Code.<br/>
     * Support running environments including both HMS and GMS which are chosen by users.<br/>
     * Below are the references of HMS apis and GMS apis respectively:<br/>
     * com.huawei.hms.maps.model.PatternItem.hashCode(): <a href="https://developer.huawei.com/consumer/en/doc/development/HMS-References/hms-map-patternitem">https://developer.huawei.com/consumer/en/doc/development/HMS-References/hms-map-patternitem</a><br/>
     * com.google.android.gms.maps.model.PatternItem.hashCode(): <a href="https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem#public-int-hashcode">https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem#public-int-hashcode</a><br/>
     *
     * @return the return object is int
     */
    public int hashCode() {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.maps.model.PatternItem) this.getHInstance()).hashCode()");
                return ((com.huawei.hms.maps.model.PatternItem) this.getHInstance()).hashCode();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.maps.model.PatternItem) this.getGInstance()).hashCode()");
                return ((com.google.android.gms.maps.model.PatternItem) this.getGInstance()).hashCode();
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((HImpl) ((com.huawei.hms.maps.model.PatternItem) this.getHInstance())).hashCodeCallSuper()");
                return ((HImpl) ((com.huawei.hms.maps.model.PatternItem) this.getHInstance())).hashCodeCallSuper();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((GImpl) ((com.google.android.gms.maps.model.PatternItem) this.getGInstance())).hashCodeCallSuper()");
                return ((GImpl) ((com.google.android.gms.maps.model.PatternItem) this.getGInstance())).hashCodeCallSuper();
            }
        }
    }
    
    /**
     * org.xms.g.maps.model.PatternItem.toString() to String.<br/>
     * Support running environments including both HMS and GMS which are chosen by users.<br/>
     * Below are the references of HMS apis and GMS apis respectively:<br/>
     * com.huawei.hms.maps.model.PatternItem.toString(): <a href="https://developer.huawei.com/consumer/en/doc/development/HMS-References/hms-map-patternitem">https://developer.huawei.com/consumer/en/doc/development/HMS-References/hms-map-patternitem</a><br/>
     * com.google.android.gms.maps.model.PatternItem.toString(): <a href="https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem#public-string-tostring">https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem#public-string-tostring</a><br/>
     *
     * @return the return object is java lang String
     */
    public java.lang.String toString() {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.maps.model.PatternItem) this.getHInstance()).toString()");
                return ((com.huawei.hms.maps.model.PatternItem) this.getHInstance()).toString();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.maps.model.PatternItem) this.getGInstance()).toString()");
                return ((com.google.android.gms.maps.model.PatternItem) this.getGInstance()).toString();
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((HImpl) ((com.huawei.hms.maps.model.PatternItem) this.getHInstance())).toStringCallSuper()");
                return ((HImpl) ((com.huawei.hms.maps.model.PatternItem) this.getHInstance())).toStringCallSuper();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((GImpl) ((com.google.android.gms.maps.model.PatternItem) this.getGInstance())).toStringCallSuper()");
                return ((GImpl) ((com.google.android.gms.maps.model.PatternItem) this.getGInstance())).toStringCallSuper();
            }
        }
    }
    
    /**
     * org.xms.g.maps.model.PatternItem.writeToParcel(android.os.Parcel,int) writeToParcel.<br/>
     * Support running environments including both HMS and GMS which are chosen by users.<br/>
     * Below are the references of HMS apis and GMS apis respectively:<br/>
     * com.huawei.hms.maps.model.PatternItem.writeToParcel(android.os.Parcel,int): <a href="https://developer.huawei.com/consumer/en/doc/development/HMS-References/hms-map-patternitem">https://developer.huawei.com/consumer/en/doc/development/HMS-References/hms-map-patternitem</a><br/>
     * com.google.android.gms.maps.model.PatternItem.writeToParcel(android.os.Parcel,int): <a href="https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem#public-void-writetoparcel-parcel-out,-int-flags">https://developers.google.com/android/reference/com/google/android/gms/maps/model/PatternItem#public-void-writetoparcel-parcel-out,-int-flags</a><br/>
     *
     * @param param0 the param should instanceof android os Parcel
     * @param param1 the param should instanceof int
     */
    public void writeToParcel(android.os.Parcel param0, int param1) {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.maps.model.PatternItem) this.getHInstance()).writeToParcel(param0, param1)");
                ((com.huawei.hms.maps.model.PatternItem) this.getHInstance()).writeToParcel(param0, param1);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.maps.model.PatternItem) this.getGInstance()).writeToParcel(param0, param1)");
                ((com.google.android.gms.maps.model.PatternItem) this.getGInstance()).writeToParcel(param0, param1);
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((HImpl) ((com.huawei.hms.maps.model.PatternItem) this.getHInstance())).writeToParcelCallSuper(param0, param1)");
                ((HImpl) ((com.huawei.hms.maps.model.PatternItem) this.getHInstance())).writeToParcelCallSuper(param0, param1);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((GImpl) ((com.google.android.gms.maps.model.PatternItem) this.getGInstance())).writeToParcelCallSuper(param0, param1)");
                ((GImpl) ((com.google.android.gms.maps.model.PatternItem) this.getGInstance())).writeToParcelCallSuper(param0, param1);
            }
        }
    }
    
    /**
     * XMS does not provide this api.<br/>
     */
    public int describeContents() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    /**
     * org.xms.g.maps.model.PatternItem.dynamicCast(java.lang.Object) dynamic cast the input object to org.xms.g.maps.model.PatternItem.<br/>
     * Support running environments including both HMS and GMS which are chosen by users.<br/>
     *
     * @param param0 the param should instanceof java lang Object
     * @return cast maps model PatternItem object
     */
    public static org.xms.g.maps.model.PatternItem dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.maps.model.PatternItem) param0);
    }
    
    /**
     * org.xms.g.maps.model.PatternItem.isInstance(java.lang.Object) judge whether the Object is XMS instance or not.<br/>
     * Support running environments including both HMS and GMS which are chosen by users.<br/>
     *
     * @param param0 the input object
     * @return true if the Object is XMS instance, otherwise false
     */
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XGettable)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XGettable) param0).getHInstance() instanceof com.huawei.hms.maps.model.PatternItem;
        } else {
            return ((org.xms.g.utils.XGettable) param0).getGInstance() instanceof com.google.android.gms.maps.model.PatternItem;
        }
    }
    
    private class GImpl extends com.google.android.gms.maps.model.PatternItem {
        
        public boolean equals(java.lang.Object param0) {
            return org.xms.g.maps.model.PatternItem.this.equals(param0);
        }
        
        public int hashCode() {
            return org.xms.g.maps.model.PatternItem.this.hashCode();
        }
        
        public java.lang.String toString() {
            return org.xms.g.maps.model.PatternItem.this.toString();
        }
        
        public void writeToParcel(android.os.Parcel param0, int param1) {
            org.xms.g.maps.model.PatternItem.this.writeToParcel(param0, param1);
        }
        
        public boolean equalsCallSuper(java.lang.Object param0) {
            return super.equals(param0);
        }
        
        public int hashCodeCallSuper() {
            return super.hashCode();
        }
        
        public java.lang.String toStringCallSuper() {
            return super.toString();
        }
        
        public void writeToParcelCallSuper(android.os.Parcel param0, int param1) {
            super.writeToParcel(param0, param1);
        }
        
        public GImpl(int param0, float param1) {
            super(param0, param1);
        }
    }
    
    private class HImpl extends com.huawei.hms.maps.model.PatternItem {
        
        public boolean equals(java.lang.Object param0) {
            return org.xms.g.maps.model.PatternItem.this.equals(param0);
        }
        
        public int hashCode() {
            return org.xms.g.maps.model.PatternItem.this.hashCode();
        }
        
        public java.lang.String toString() {
            return org.xms.g.maps.model.PatternItem.this.toString();
        }
        
        public void writeToParcel(android.os.Parcel param0, int param1) {
            org.xms.g.maps.model.PatternItem.this.writeToParcel(param0, param1);
        }
        
        public boolean equalsCallSuper(java.lang.Object param0) {
            return super.equals(param0);
        }
        
        public int hashCodeCallSuper() {
            return super.hashCode();
        }
        
        public java.lang.String toStringCallSuper() {
            return super.toString();
        }
        
        public void writeToParcelCallSuper(android.os.Parcel param0, int param1) {
            super.writeToParcel(param0, param1);
        }
        
        public HImpl(int param0, float param1) {
            super(param0, param1);
        }
    }
}